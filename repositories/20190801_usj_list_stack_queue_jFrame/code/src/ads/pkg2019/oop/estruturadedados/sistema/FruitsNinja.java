package ads.pkg2019.oop.estruturadedados.sistema;

import java.util.ArrayList;
import static java.util.Collections.reverse;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class FruitsNinja {

    public static List<String> installFruitsList(List<String> frutas) {
        frutas = new ArrayList<>();
        install(frutas);
        return frutas;
    }

    public static Queue<String> installFruitsFila(Queue<String> frutas) {
        frutas = new LinkedList<>();
        install(frutas);
        return frutas;
    }

    public static Stack<String> installFruitsPilha(Stack<String> frutas) {
        frutas = new Stack<>();
        install(frutas);
        return frutas;
    }

    public static List<String> install(List<String> frutas) {
        frutas.add("Abacate");
        frutas.add("Abacaxi");
        frutas.add("Abiu");
        frutas.add("Araçá");
        frutas.add("Azeitona (Olive)");
        frutas.add("Açai");
        frutas.add("Acerola");
        frutas.add("Ameixa (plum)");
        frutas.add("Amora (Blackberry)");
        frutas.add("Abóbora");
        frutas.add("Butiá");
        frutas.add("Cacau");
        frutas.add("Cereja");
        frutas.add("Coco (Coconut)");
        frutas.add("Caqui");
        frutas.add("Damasco");
        frutas.add("Figo");
        frutas.add("Fruta-pão");
        frutas.add("Fruta-do-conde");
        frutas.add("Goiaba");
        frutas.add("Jabuticaba");
        frutas.add("Jambolão");
        frutas.add("Jamelão");
        frutas.add("Kiwi");
        frutas.add("Laranja");
        frutas.add("Lichia");
        frutas.add("Limi]ao");
        frutas.add("Maça");
        frutas.add("Manga");
        frutas.add("Maracujá");
        frutas.add("Mamão");
        frutas.add("Melancia");
        frutas.add("Melão");
        frutas.add("Mirtilo");
        frutas.add("Morango");
        frutas.add("Pinha");
        frutas.add("Pinhão");
        frutas.add("Pistache");
        frutas.add("Pitaya");
        frutas.add("Romã");
        frutas.add("Tâmara");
        frutas.add("Tamarindo");
        frutas.add("Tangerina");
        frutas.add("Tomate");
        frutas.add("Uva");
        
        return frutas;
    }

    public static Queue<String> install(Queue<String> frutas) {
        frutas.add("Abacate");
        frutas.add("Abacaxi");
        frutas.add("Abiu");
        frutas.add("Araçá");
        frutas.add("Azeitona (Olive)");
        frutas.add("Açai");
        frutas.add("Acerola");
        frutas.add("Ameixa (plum)");
        frutas.add("Amora (Blackberry)");
        frutas.add("Abóbora");
        frutas.add("Butiá");
        frutas.add("Cacau");
        frutas.add("Cereja");
        frutas.add("Coco (Coconut)");
        frutas.add("Caqui");
        frutas.add("Damasco");
        frutas.add("Figo");
        frutas.add("Fruta-pão");
        frutas.add("Fruta-do-conde");
        frutas.add("Goiaba");
        frutas.add("Jabuticaba");
        frutas.add("Jambolão");
        frutas.add("Jamelão");
        frutas.add("Kiwi");
        frutas.add("Laranja");
        frutas.add("Lichia");
        frutas.add("Limi]ao");
        frutas.add("Maça");
        frutas.add("Manga");
        frutas.add("Maracujá");
        frutas.add("Mamão");
        frutas.add("Melancia");
        frutas.add("Melão");
        frutas.add("Mirtilo");
        frutas.add("Morango");
        frutas.add("Pinha");
        frutas.add("Pinhão");
        frutas.add("Pistache");
        frutas.add("Pitaya");
        frutas.add("Romã");
        frutas.add("Tâmara");
        frutas.add("Tamarindo");
        frutas.add("Tangerina");
        frutas.add("Tomate");
        frutas.add("Uva");
        return frutas;
    }

    public static Stack<String> install(Stack<String> frutas) {
        frutas.push("Abacate");
        frutas.push("Abacaxi");
        frutas.push("Abiu");
        frutas.push("Araçá");
        frutas.push("Azeitona (Olive)");
        frutas.push("Açai");
        frutas.push("Acerola");
        frutas.push("Ameixa (plum)");
        frutas.push("Amora (Blackberry)");
        frutas.push("Abóbora");
        frutas.push("Butiá");
        frutas.push("Cacau");
        frutas.push("Cereja");
        frutas.push("Coco (Coconut)");
        frutas.push("Caqui");
        frutas.push("Damasco");
        frutas.push("Figo");
        frutas.push("Fruta-pão");
        frutas.push("Fruta-do-conde");
        frutas.push("Goiaba");
        frutas.push("Jabuticaba");
        frutas.push("Jambolão");
        frutas.push("Jamelão");
        frutas.push("Kiwi");
        frutas.push("Laranja");
        frutas.push("Lichia");
        frutas.push("Limi]ao");
        frutas.push("Maça");
        frutas.push("Manga");
        frutas.push("Maracujá");
        frutas.push("Mamão");
        frutas.push("Melancia");
        frutas.push("Melão");
        frutas.push("Mirtilo");
        frutas.push("Morango");
        frutas.push("Pinha");
        frutas.push("Pinhão");
        frutas.push("Pistache");
        frutas.push("Pitaya");
        frutas.push("Romã");
        frutas.push("Tâmara");
        frutas.push("Tamarindo");
        frutas.push("Tangerina");
        frutas.push("Tomate");
        frutas.push("Uva");
        reverse(frutas);
        return frutas;
    }

}
