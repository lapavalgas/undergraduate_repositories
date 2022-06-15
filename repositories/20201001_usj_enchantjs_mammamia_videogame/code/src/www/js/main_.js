
enchant();

var screenWidth = window.screen.availWidth
var screenHeight = window.screen.availHeight

// alert('w:' + screenWidth +' h:' + screenHeight)


window.onload = function () {
    // Starting point
    var game = new Game(screenWidth, screenHeight);
    game.preload('res/BG.png',
        'res/penguinSheet.png',
        'res/Ice.png',
        'res/Hit.mp3',
        'res/bgm.mp3',
        'res/down.png');
    game.fps = 30;
    game.scale = 1;
    game.onload = function () {
        // Once Game finish loading
        var scene = new SceneGame();
        game.pushScene(scene);
    }
    //window.scrollTo(0,0);
    game.start();
    window.scrollTo(0, 0);
};

/**
 * SceneGame  
 */
var SceneGame = Class.create(Scene, {
    /**
     * The main gameplay scene.     
     */
    initialize: function () {
        var game, label, bg, penguin, iceGroup, down;

        // Call superclass constructor
        Scene.apply(this);

        // Access to the game singleton instance
        game = Game.instance;

        label = new Label('POOPS<br>0');
        label.x = 9;
        label.y = 32;
        label.color = 'black';
        label.font = '20px strong';
        label.textAlign = 'center';
        label._style.textShadow = "-1px 0 black, 0 1px black, 1px 0 black, 0 -1px black";
        this.scoreLabel = label;

        labelh = new Label('LIFES<br>5');
        labelh.x = 9;
        labelh.y = 64;
        labelh.color = 'black';
        labelh.font = '20px strong';
        labelh.textAlign = 'center';
        labelh._style.textShadow = "-1px 0 black, 0 1px black, 1px 0 black, 0 -1px black";
        this.healthLabel = labelh;

        bg = new Sprite(screenWidth, screenHeight);
        bg.image = game.assets['res/BG.png'];

        penguin = new Penguin();
        penguin.x = game.width / 2 - penguin.width / 2;
        penguin.y = (screenHeight * 2 )/ 3;
        this.penguin = penguin;

        down = new Down();
        down.x = game.width / 2 - down.width / 2;
        down.y = screenHeight;
        this.down = down;

        iceGroup = new Group();
        this.iceGroup = iceGroup;

        this.addChild(bg);
        this.addChild(iceGroup);
        this.addChild(penguin);
        this.addChild(label);
        this.addChild(labelh);
        this.addChild(down);

        this.addEventListener(Event.TOUCH_START, this.handleTouchControl);
        this.addEventListener(Event.ENTER_FRAME, this.update);

        // Instance variables
        this.generateIceTimer = 0;
        this.scoreTimer = 0;
        this.score = 0;
        this.health = 5;

        this.bgm = game.assets['res/bgm.mp3']; // Add this line

        // Start BGM
        this.bgm.play();
    },

    handleTouchControl: function (evt) {
        var laneWidth, lane;
        laneWidth = screenWidth / 3;
        lane = Math.floor(evt.x / laneWidth);
        lane = Math.max(Math.min(2, lane), 0);
        this.penguin.switchToLaneNumber(lane);
    },

    update: function (evt) {
        // Check if it's time to create a new set of obstacles
        this.generateIceTimer += evt.elapsed * 0.001;
        if (this.generateIceTimer >= 0.5) {
            var ice;
            this.generateIceTimer -= 0.5;
            ice = new Ice(Math.floor(Math.random() * 3));
            this.iceGroup.addChild(ice);
        }

        // Check collision
        for (var i = this.iceGroup.childNodes.length - 1; i >= 0; i--) {
            var ice;
            ice = this.iceGroup.childNodes[i];
            if (ice.intersect(this.penguin)) {
                var game;
                game = Game.instance;
                game.assets['res/Hit.mp3'].play();
                this.iceGroup.removeChild(ice);
                this.setScore(this.score + 1);
                //this.setHealth(this.health - 1);
                this.scoreTimer -= 0.5;
                break;
            }
        }

        for (var i = this.iceGroup.childNodes.length - 1; i >= 0; i--) {
            var ice;
            ice = this.iceGroup.childNodes[i];
            if (ice.intersect(this.down)) {
                var game;
                game = Game.instance;
                this.iceGroup.removeChild(ice);
                this.setHealth(this.health - 1);
                this.scoreTimer -= 0.5;
                if (this.health === 0 ) {
                    this.bgm.stop();
                    game.replaceScene(new SceneGameOver(this.score));      
                }
                break;
            }
        }


        // Loop BGM
        if (this.bgm.currentTime >= this.bgm.duration) {
            this.bgm.play();
        }
    },

    setHealth: function (value) {
        this.health = value;
        this.healthLabel.text = 'LIFE<br>' + this.health

    },

    setScore: function (value) {
        this.score = value;
        this.scoreLabel.text = 'POOPS<br>' + this.score;
    }
});

/**
 * Penguin
 */
var Penguin = Class.create(Sprite, {
    /**
     * The player character.     
     */
    initialize: function () {
        // Call superclass constructor
        Sprite.apply(this, [60, 64]);
        this.image = Game.instance.assets['res/penguinSheet.png'];
        this.animationDuration = 0;
        this.addEventListener(Event.ENTER_FRAME, this.updateAnimation);
    },

    updateAnimation: function (evt) {
        this.animationDuration += evt.elapsed * 0.001;
        if (this.animationDuration >= 0.25) {
            this.frame = (this.frame + 1) % 2;
            this.animationDuration -= 0.25;
        }
    },

    switchToLaneNumber: function (lane) {
        var targetX = (screenWidth/2) - this.width / 2 + (lane - 1) * 90;
        this.x = targetX;
    }
});

/**
* Ice Cube
*/
var Ice = Class.create(Sprite, {
    /**
     * The obstacle that the penguin must avoid
     */
    initialize: function (lane) {
        // Call superclass constructor
        Sprite.apply(this, [48, 49]);
        this.image = Game.instance.assets['res/Ice.png'];
        this.rotationSpeed = 0;
        this.setLane(lane);
        this.addEventListener(Event.ENTER_FRAME, this.update);
    },

    setLane: function (lane) {
        var game, distance;
        game = Game.instance;
        distance = 90;

        this.rotationSpeed = Math.random() * 100 - 50;

        this.x = game.width / 2 - this.width / 2 + (lane - 1) * distance;
        this.y = -this.height;
        this.rotation = Math.floor(Math.random() * 360);
    },

    update: function (evt) {
        var ySpeed, game;

        game = Game.instance;
        ySpeed = 300;

        this.y += ySpeed * evt.elapsed * 0.001;
        this.rotation += this.rotationSpeed * evt.elapsed * 0.001;
        if (this.y > game.height) {
            this.parentNode.removeChild(this);
        }
    }
});

var Down = Class.create(Sprite, {
    initialize: function () {
        Sprite.apply(this, [320, 40]);
        this.image = Game.instance.assets['res/down.png'];
    },
})

/**
 * SceneGameOver  
 */
var SceneGameOver = Class.create(Scene, {
    initialize: function (score) {
        var gameOverLabel, scoreLabel;
        Scene.apply(this);
        this.backgroundColor = 'black';

        scoreLabel = new Label('POOPS<br>' + score);
        scoreLabel.x = screenWidth * 0.1;
        scoreLabel.y = screenHeight * 0.05;
        scoreLabel.color = 'white';
        scoreLabel.font = '16px strong';
        scoreLabel.textAlign = 'center';

        gameOverLabel = new Label("GAME OVER<br><br>Tap to Restart");
        gameOverLabel.x = screenWidth * 0.1;
        gameOverLabel.y = screenHeight * 0.15;
        gameOverLabel.color = 'white';
        gameOverLabel.font = '32px strong';
        gameOverLabel.textAlign = 'center';

      

        this.addChild(gameOverLabel);
        this.addChild(scoreLabel);

        this.addEventListener(Event.TOUCH_START, this.touchToRestart);


    },

    touchToRestart: function (evt) {
        var game = Game.instance;
        game.replaceScene(new SceneGame());
    }
});