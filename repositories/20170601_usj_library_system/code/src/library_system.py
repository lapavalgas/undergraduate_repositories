#
#
#                                                               Universidade de São José
#                                       
#                                                                     Algoritimo
#
#                                                                   Trabalho final 
#
#
#
#                                                                 Rafael Lapa Valgas
#                                                                
#                                                                    
#                                                                  
#
#=#=#=#=#=#=#=#=#=#
### L I V R O S ###
###################+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

class Livros:   
    seq = 0 
    objects = [] 
    
    def __init__ (self, nomeLivro, autorLivro, editoraLivro, tipoLivro):
        self.id = int
        self.idLivro = int
        self.nomeLivro = nomeLivro
        self.autorLivro = autorLivro
        self.editoraLivro = editoraLivro
        self.tipoLivro = tipoLivro
            
    def save(self):
        self.__class__.seq += 1
        self.id = self.__class__.seq
        self.idLivro = int(str(self.__class__.seq) + str(self.tipoLivro))
        self.__class__.objects.append(self)
    
    def __str__(self):
        return self.idLivro
    
    def __repr__(self):
        return (' {}: {} - {} - {} - {} - {} - {} \n').format(self.__class__.__name__, self.id, self.idLivro, self.nomeLivro, self.autorLivro, self.editoraLivro, self.tipoLivro)

    def listarFormat(self):
      listarFormat = []
      listarFormat.append(self.id) # 0- ID
      listarFormat.append(self.idLivro)# 1- ID User
      listarFormat.append(self.nomeLivro)# 2- Nome
      listarFormat.append(self.autorLivro)  # 3- autor
      listarFormat.append(self.editoraLivro)  # 4- editora
      listarFormat.append(self.tipoLivro) # 5 tipo livro
      return listarFormat    
    
    @classmethod
    def all(cls):
        return cls.objects
    
    @classmethod
    def cadastrarLivro(cls):
        nomeLivro = input('Digite o nome do livro...')
        autorLivro = input('digite o nome do Autor...')
        editoraLivro = input('Digite o nome da editora...')
        tipoLivro = input('Digite o tipo do livro: [1] ciencias, [2] artes...')
        novoLivro = Livros(nomeLivro, autorLivro, editoraLivro, tipoLivro)
        novoLivro.save()
        return print('concluido')


#=#=#=#=#=#=#=#
### U S E R ###
###############

class User:
    seq = 0
    objects = []
 
    def __init__(self, nomeUser, rgUser, mailUser, senhaUser):
        self.id = int 
        self.idUser = int 
        self.nomeUser = nomeUser
        self.rgUser = rgUser
        self.mailUser = mailUser
        self.senhaUser = senhaUser
    
    def __str__(self):
        return self.nomeUser 
    
    def __repr__(self):
        return (' {}: {} - {} - {} - {} - {} - {} \n '.format(self.__class__.__name__, self.id, self.idUser, self.nomeUser, self.rgUser, self.mailUser, self.senhaUser))

    def dataLoginVer(self, dataLogin):
        if (dataLogin == self.idUser):
            return True
        else:
            return False
    
    def dataSenhaVer(self, dataLogin):
        return self.senhaUser

    def listarFormat(self):
      listarFormat = []
      listarFormat.append(self.id) # 1- ID
      listarFormat.append(self.idUser)# 2- ID User
      listarFormat.append(self.nomeUser)# 3- Nome
      listarFormat.append(self.rgUser)  # 4- RG
      listarFormat.append(self.mailUser)  # 5- Email
      return listarFormat

    @classmethod
    def all(cls):
        return cls.objects

class Gerente(User):   
    def save(self):
        self.__class__.seq += 1
        self.id = self.__class__.seq
        self.idUser = 1000 + self.id
        self.__class__.objects.append(self)
     
    def cadastrarGerente(self, cls):
        nomeUser = input('Digite o nome do novo Gerente...')
        rgUser = input('Digite o número do RG...')
        mailUser = input('Digite o e-mail do Gerente...')
        senhaUser = input('Solicite a entrada da senha...')
        novoGerente = Gerente(nomeUser, rgUser, mailUser, senhaUser)
        novoGerente.save()
        print(novoGerente.__repr__())
        return print('concluido')

class Leitor(User):
    def save(self):
        self.__class__.seq += 1
        self.id = self.__class__.seq
        self.idUser = 10 + self.id
        self.__class__.objects.append(self)
     
    def cadastrarLeitor(self, cls):
        nomeUser = input('Digite o nome do novo Leitor...')
        rgUser = input('Digite o número do RG...')
        mailUser = input('Digite o e-mail do Leitor...')
        senhaUser = input('Solicite a entrada da senha...')
        novoLeitor = Leitor(nomeUser, rgUser, mailUser, senhaUser)
        novoLeitor.save()
        print(novoLeitor.__repr__())
        return print('concluido')

  
  
      
#=#=#=#=#=#=#=#
### M E N U ###
###############

#VERIFICA LOGIN
def loginVer(dataLogin):
    for i in range (len(User.objects)):
        dataLogin[2] = User.objects[i].dataLoginVer(dataLogin[1]) #verifica se o input do usuário é igual ao login do usuário em 'for' [i]
        if (dataLogin[2] == True):
            dataLogin[3] = User.objects[i].__str__()
            dataLogin[4] = int(User.objects[i].dataSenhaVer(dataLogin[i]))
            dataLogin[6] = User.objects[i].__class__       
            return dataLogin
        else:
            if (i > (len(User.objects))):
                return dataLogin
    return dataLogin  

#LOGIN
def login():
    print('\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n')
    print("""
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=.
--  B E M   V I N D O                          |
=----------------------------------------------|
--  Sistema para Cadastro de LIVROS e          |                                      
--                            novos LEITORES   |
-----------------------------------------------|
=-                  : : Versão do sistema: 1   |
-----------------------------------------------'                                   
=-  Digite seu login: o ID de usuário. 
=-  :: Somente números ::
=-""")                                                                   
    dataLogin = []
    menuSteps = True
    dataLogin.append(menuSteps)         #0 liga / desliga sistema login
    menuLogin = int
    dataLogin.append(menuLogin)         #1 input : user
    menuLoginVer = False
    dataLogin.append(menuLoginVer)      #2 verifica BOOL do login
    menuUserName = str
    dataLogin.append(menuUserName)      #3 nome do usuário, para levar o nomer de usuário ao menu
    menuSenha = int
    dataLogin.append(menuSenha)         #4 retorna senha usuário
    menuToks = 3
    dataLogin.append(menuToks)          #5 total de chances para senha
    userType = str
    dataLogin.append(userType)          #6 tipo de usuário para carregar menu, após login
    userBook = []
    dataLogin.append(userBook)          #7 array com livros de usuário
    userType = bool                     
    dataLogin.append(userType)          #8 determina o tipo de usuário 
    while (dataLogin[0] == True):
            dataLogin[1] = int(input('=- >>  ')) 
            dataLogin = loginVer(dataLogin)
            if (dataLogin[2] == True):
                if (dataLogin[1] > 1000):
                    dataLogin[8] = True
                elif (dataLogin[1] < 999):
                    dataLogin[8] = False
                print('=-  Usuário localizado com sucesso!')
                print('=- ..... Bem vindo, ', dataLogin[3], '.')
                print('=-                                                  ;)\n', end="")                
                for i in range (dataLogin[5]):
                    print('=-  Digite a sua senha de usuário.')
                    print('=-  :: Somente números ::')
                    senha = int(input('=- >>  '))
                    if (senha == dataLogin[4]):
                        print('=-  Login efetuado com sucesso!! \n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=======================>>>>\n=-\n=-', end="")
                        dataLogin[0] = False
                        userId = dataLogin[1]
                        userName = dataLogin[3]
                        userType = dataLogin[6]
                        userBook = dataLogin[7]
                        menuType = []
                        menuType.append(userId)     #0 Login do usuário
                        menuType.append(userName)   #1 Nome do usuário
                        menuType.append(userType)   #2 Tipo do usuário
                        menuType.append(userBook)   #3 matriz de livros do usuário
                        menuType.append(dataLogin[8]) #4 bool tipo menu
                        print(' .....Aperte para continuar...', end="")
                        m__ = input()
                        return menuType       
                        # break
                    else:
                        print('=-  Senha incorreta\n=-  ')        
                else:                        
                    print('*******************************\n* Falha ao estabelecer Login.')
                    print('* Sair  ')
                    print('* Senha incorreta. Tente novamente.')
                    print('*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---------------------------- -  -   -    -     -      -       -        -         -')
                    print(' .....Aperte para continuar...', end="")
                    m__ = input()
                    return [] 
            else:
                print('=-  Usuário não localizado!!    :( ')
                print('=-  Tente novamente.')    
    print('passou!')
           
def menu(menuType):
    print(menuType[4])
    if (menuType[4] == True):
        logoutOff = menuGerente(menuType)
        if (logoutOff == False):
            return False
        elif (logoutOff == None):
            return None
    else:
        logoutOff = menuLeitor(menuType)
        if (logoutOff == False):
            return False
        elif (logoutOff == None):
            return None
  

#CADASTRO_LEITOR
def menuCadastrarLeitor():
    print("""=-
-----------------------------------------------.
=-  Entrar com os dados do Leitor/cliente      |
-----------------------------------------------'  
=-\n=-  >>>  """, end="")
    nomeLeitor = input('Nome:  ')
    print('=-  >>>  ', end="")
    rgLeitor = input('RG:  ')
    print('=-  >>>  ', end="")
    emailLeitor = input('E-mail:  ')
    print('=-  >>>  ', end="")
    senhaLeitor = input('Senha:  ')
    print('=-----------------------------------------------')
    print('=-\n=-  Você deseja cadastrar o Leitor:\n=-')
    print('=-      Nome:', nomeLeitor)
    print('=-        RG:', rgLeitor)
    print('=-    E-mail:', emailLeitor)
    print('=-     Senha:', '****')
    print('=-\n=-      [ 1 ] - SIM   |   [ 0 ] - NÃO\n=-\n=-  ', end="")
    m__ = int(input())
    if (m__ == 1):
        print('=-----------------------------------------------')
        print('=-  REGISTRADO  < <<')
        print('=-----------------------------------------------\n=-')
        novoLeitor = Leitor(nomeLeitor, rgLeitor, emailLeitor, senhaLeitor) 
        novoLeitor.save()
        print('=-  A ID do cliente', nomeLeitor, 'é:  ', novoLeitor.idUser, '.\n=-')
        print('=-  Utilizar a ID para efetuar login.')
        print('=-  ')
        print('=- ...Aperte para continuar...')
        n__ = input()
        print('=-----------------------------------------------')
        return None
    else:
        print('=-----------------------------------------------')
        return None

#CADASTRO DE LIVROS
def menuCadastroLivros():
    print("""=-
-----------------------------------------------.
=-  Entrar com os dados do Livro               |
-----------------------------------------------'  
=-""")
    print('=-     Classificações disponíveis: \n=-')
    print('=-     [1] Ciência     | [2] Artes \n=-     [3] Literatura  | [4] Politica\n=-')
    nomeLivro = input('=-  >>>           Nome:  ')
    autorLivro = input('=-  >>>          Autor:  ')
    editoraLivro = input('=-  >>>        Editora:  ')
    tipoLivro = input('=-  >>>  Classificação:  ')
    print('=-----------------------------------------------')
    print('=-\n=-  Você deseja cadastrar o Livro:\n=-')
    print('=-  ', nomeLivro)
    print('=-  ', autorLivro)
    print('=-  ', editoraLivro)
    print('=-  ', tipoLivro)
    print('=-\n=-      [ 1 ] - SIM   |   [ 0 ] - NÃO\n=-\n=-  ', end="")
    m__ = int(input())
    if (m__ == 1):
        print('=-----------------------------------------------')
        print('=-  REGISTRADO  < <<')
        print('=-----------------------------------------------\n=-')
        novoLivro = Livros(nomeLivro, autorLivro, editoraLivro, tipoLivro) 
        novoLivro.save()
        print('=- ...Aperte para continuar...')
        n__ = input()
        print('=-----------------------------------------------')
        return None
    else:
        print('=-----------------------------------------------')
        return None  

#LOCALIZAR LEITOR NA LISTA 
def menuLocalizarLeitor():
    leitoresList = []
    for i in range (len(Leitor.objects)):
        LeitorSelect = Leitor.objects[i]
        listarFormat = LeitorSelect.listarFormat()
        leitoresList.append(listarFormat)
        #idSistema = listarFormat[0]
        #idUser = listarFormat[1]
        #nomeLeitor = listarFormat[2]
        #rgUser = listarFormat[3]
        #mailUser = listarFormat[4]
    menuPrintLeitor(leitoresList)
  
def menuPrintLeitor(leitoresList):  
    n__ = 1
    while (n__ != 0):
        print('=-\n=-  [ 0 ] - SAIR\n=-  ') 
        print('=-  [ 1 ] - Localizar por Nome')
        print('=-  [ 2 ] - Localizar por ID')
        print('=-  [ 3 ] - Localizar por RG\n=-  ', end="")  
        inputType = int(input())
        if (inputType == 1):
            print('=-\n=-  Digite o Nome do cliente a ser localizado: \n=-\n=-  ', end="")
            searchTag = str(input())
            print('=-\n=-=-=-=-=-=-=-=-=-=---- -  -   -    -     -      -       -        -\n=-\n=-') 
            for j in range (len(leitoresList)):
                cond1 = searchTag.upper()
                cond1 = str(cond1)
                cond2 = (leitoresList)[j][2]
                cond2 = cond2.upper()
                cond2 = str(cond2)
                if (cond1 == cond2):
                    localizado(searchTag, leitoresList, j)
        elif (inputType == 2):
            print('=-\n=-  Digite o ID do cliente a ser localizado: \n=-\n=-  ', end="")
            searchTag = int(input())
            print('=-\n=-=-=-=-=-=-=-=-=-=---- -  -   -    -     -      -       -        -\n=-\n=-') 
            for j in range (len(leitoresList)):
                cond1 = (int(searchTag))
                cond2 = (leitoresList)[j][1]
                if (cond1 == cond2):
                    localizado(searchTag, leitoresList, j)
        elif (inputType == 3):
            print('=-\n=-  Digite o RG do cliente a ser localizado: \n=-\n=-  ', end="")
            searchTag = int(input())
            print('=-\n=-=-=-=-=-=-=-=-=-=---- -  -   -    -     -      -       -        -\n=-\n=-') 
            for j in range (len(leitoresList)):
                cond1 = (int(searchTag))
                cond2 = (leitoresList)[j][3]
                if (cond1 == cond2):
                    localizado(searchTag, leitoresList, j)    
        else:
            if (inputType == 0):
                n__ = 0
                return None

def localizado(searchTag, leitoresList, j):
    print('=-\n=-\n=-=-=-=-=-=-=-=-=-=---- -  -   -    -     -      -       -        -')
    print('=-  [', leitoresList[j][0], '] - Sistema')
    print('=-=-=-=-=-=-=-=-=-=---- -  -   -    -     -      -       -        -')
    print('=-   Nome do Leitor: ', leitoresList[j][2])
    print('=- E-Mail do Leitor: ', leitoresList[j][3])
    print('=-        nº Livros: ', '.')
    print('=-               $ : ', '.')
    print('=-     RG do Leitor: ', leitoresList[j][2])
    print('=-         Endereço: ', '.')
    print('=-                   ')
    print('=-    ID de Usuário: ', leitoresList[j][1])
    print('=-=-=-=-=-=-=-=-=-=---- -  -   -    -     -      -       -        -\n=-\n=-') 
    
#LOCALIZAR LIVRO NA LISTA 
def menuLocalizarLivro():
    livrosList = []
    for i in range (len(Livros.objects)): ###########
        livroSelect = Livros.objects[i].listarFormat() #já está atuando como listarFormat dos leitores!!!
        livrosList.append(livroSelect)
        #idSistema = listarFormat[0]
        #idLivro = listarFormat[1]
        #nomeLivro = listarFormat[2]
        #autorUser = listarFormat[3]
        #editoraLivro = listarFormat[4]
        #tipoLivro = listarFormat[5]
    print(livrosList)
    menuPrintLivros(livrosList)

def menuPrintLivros(livrosList):  
    n__ = 1 
    while (n__ != 0):
        print('=-\n=-  [ 0 ] - SAIR\n=-  ') 
        print('=-  [ 1 ] - Localizar por Titulo')
        print('=-  [ 2 ] - Localizar por Autor')
        print('=-  [ 3 ] - Localizar pelo Código/ID do Livro\n=-  ')
        inputType = int(input())
        if (inputType == 1):
            print('=-  Digite o Titulo do Livro a ser localizado: \n=-\n=-  ', end="")
            searchTag = str(input())
            print('=-\n=-=-=-=-=-=-=-=-=-=---- -  -   -    -     -      -       -        -\n=-\n=-') 
            for j in range (len(livrosList)):
                cond1 = searchTag.upper()
                cond1 = str(cond1)
                cond2 = (livrosList)[j][2]
                cond2 = cond2.upper()
                cond2 = str(cond2)
                if (cond1 == cond2):
                    livroLocalizado(searchTag, livrosList, j)
        elif (inputType == 2):
            print('=-\n=-  Digite o Autor do Livro a ser localizado: \n=-\n=-  ', end="")
            searchTag = str(input())
            print('=-\n=-=-=-=-=-=-=-=-=-=---- -  -   -    -     -      -       -        -\n=-\n=-') 
            for j in range (len(livrosList)):
                cond1 = searchTag.upper()
                cond1 = str(cond1)
                cond2 = (livrosList)[j][3]
                cond2 = cond2.upper()
                cond2 = str(cond2)
                if (cond1 == cond2):
                    livroLocalizado(searchTag, livrosList, j)
        elif (inputType == 3):
            print('=-\n=-  Digite o Código do cliente a ser localizado: \n=-\n=-  ', end="")
            searchTag = int(input())
            print('=-\n=-=-=-=-=-=-=-=-=-=---- -  -   -    -     -      -       -        -\n=-\n=-') 
            for j in range (len(livrosList)):
                cond1 = (int(searchTag))
                cond2 = (livrosList)[j][1]
                if (cond1 == cond2):
                    localizado(searchTag, livrosList, j)    
        else:
            if (inputType == 0):
                n__ = 0
                return None

def livroLocalizado(searchTag, livrosList, j):
    if (int(livrosList[j][5]) == 1):
        tipoLivroText2 = 'Ciências'
    elif (int(livrosList[j][5]) == 2):
        tipoLivroText2 = 'Artes'
    elif (int(livrosList[j][5]) == 3):
        tipoLivroText2 = 'Literatura'
    elif (int(livrosList[j][5]) == 4):
        tipoLivroText2 = 'Politica'
    print('=-\n=-\n=-=-=-=-=-=-=-=-=-=---- -  -   -    -     -      -       -        -')
    print('=-  [', livrosList[j][0], '] - Sistema')
    print('=-=-=-=-=-=-=-=-=-=---- -  -   -    -     -      -       -        -')
    print('=-   Titulo do Livro: ', livrosList[j][2])
    print('=-    Autor do Livro: ', livrosList[j][3])
    print('=-  Editora do livro: ', livrosList[j][4])
    print('=-     Tipo do livro: ', livrosList[j][5])
    print('=-   Código do livro: ', livrosList[j][1])
    print('=-=-=-=-=-=-=-=-=-=---- -  -   -    -     -      -       -        -\n=-\n=-') 
 

#LISTAR LEITOR
def menuListarLeitor():
    for i in range (len(Leitor.objects)):
        j = Leitor.objects[i]
        listarFormat = j.listarFormat()
        idSistema = listarFormat[0]
        idUser = listarFormat[1]
        nomeLeitor = listarFormat[2]
        rgUser = listarFormat[3]
        mailUser = listarFormat[4]
        print('=-=-=-=-=-=-=-=-=-=---- -  -   -    -     -      -       -        -')
        print('=-  [', idSistema, '] - Sistema')
        print('=-=-=-=-=-=-=-=-=-=---- -  -   -    -     -      -       -        -')
        print('=-   Nome do Leitor: ', nomeLeitor)
        print('=- E-Mail do Leitor: ', mailUser)
        print('=-        nº Livros: ', '.')
        print('=-               $ : ', '.')
        print('=-     RG do Leitor: ', rgUser)
        print('=-         Endereço: ', '.')
        print('=-                   ')
        print('=-    ID de Usuário: ', idUser)
        print('=-=-=-=-=-=-=-=-=-=---- -  -   -    -     -      -       -        -\n=-\n=-')
    print('=- ...Aperte para continuar...')
    m__ = input()

#LISTAR LIVROS
def menuListarLivros():
    for i in range (len(Livros.objects)):
        j = Livros.objects[i]
        listarFormat = j.listarFormat()
        idSistema = listarFormat[0]
        idLivro = listarFormat[1]
        nomeLivro = listarFormat[2]
        autorLivro = listarFormat[3]
        editoraLivro = listarFormat[4]
        tipoLivro = int(listarFormat[5])
        tipoLivroText = str
        if (tipoLivro == 1):
            tipoLivroText = 'Ciências'
        elif (tipoLivro == 2):
            tipoLivroText = 'Artes'
        elif (tipoLivro == 3):
            tipoLivroText = 'Literatura'
        elif (tipoLivro == 4):
            tipoLivroText = 'Politica'
        print('=-=-=-=-=-=-=-=-=-=---- -  -   -    -     -      -       -        -')
        print('=-  [', idSistema, '] - Sistema')
        print('=-=-=-=-=-=-=-=-=-=---- -  -   -    -     -      -       -        -')
        print('=-    Nome do Livro : ', nomeLivro)
        print('=-            Autor : ', autorLivro)
        print('=-          Editora : ', editoraLivro)
        print('=-    Tipo do Livro : ', tipoLivroText)
        print('=-=-=-=-=-=-=-=-=-=---- -  -   -    -     -      -       -        -\n=-\n=-')
    print('=- ...Aperte para continuar...')
    m__ = input()

#MENU DO GERENTE
def menuGerente(menuType):
    showMenu = True
    while (showMenu == True):
        print('=-\n=-\n=-')
        print("""=-
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=.
--  M E N U                         GERENTE :: |
=----------------------------------------------|
--  [ 1 ] - Cadastrar novos Leitores           |
=-  [ 2 ] - Cadastrar novos Livros             |
=-  [ 3 ] - Listar Leitores                    |
=-  [ 4 ] - Listar Livros                      |
=-  [ 5 ] - Localizar Leitores                 |
=-  [ 6 ] - Localizar Livros                   |
=-  [ 7 ] - Logoff                             |
=-  [ 8 ] - Desligar                           | 
-----------------------------------------------|
=-                  : : Versão do sistema: 1   |
-----------------------------------------------'                               
=-  Que operação deseja efetuar? 
=-  Escolha o número correspondente.
=-  :: Somente números ::
=-""")
        menuAct = int(input('=-  '))  
        if (menuAct == 1):
            menuCadastrarLeitor()
        elif (menuAct == 2):
            menuCadastroLivros()
        elif (menuAct == 3):
            menuListarLeitor()
        elif (menuAct == 4):
            menuListarLivros() 
        elif (menuAct == 5):
            menuLocalizarLeitor()     
        elif (menuAct == 6):
            menuLocalizarLivro()
        elif (menuAct == 7):
            return False
        elif (menuAct == 8):
            return None
        else:
            print('\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n')
            menuGerente(menuType)

def menuLeitor(menuType):
    showMenu = True
    while (showMenu == True):
        print('=-\n=-\n=-')
        print("""=-
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=.
--  M E N U                         GERENTE :: |
=----------------------------------------------|
=-  [ 1 ] - Listar Leitores                    |
=-  [ 2 ] - Listar Livros                      |
=-  [ 3 ] - Localizar Leitores                 |
=-  [ 4 ] - Localizar Livros                   |
=-  [ 5 ] - Logoff                             |
=-  [ 6 ] - Desligar                           | 
-----------------------------------------------|
=-                  : : Versão do sistema: 1   |
-----------------------------------------------'                               
=-  Que operação deseja efetuar? 
=-  Escolha o número correspondente.
=-  :: Somente números ::
=-""")
        menuAct = int(input('=-  '))  
        if (menuAct == 1):
            menuListarLeitor()
        elif (menuAct == 2):
            menuListarLivros() 
        elif (menuAct == 3):
            menuLocalizarLeitor()     
        elif (menuAct == 4):
            menuLocalizarLivro()
        elif (menuAct == 5):
            return False
        elif (menuAct == 6):
            return None
        else:
            print('\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n')
            menuLeitor(menuType)



#=#=#=#=#=#=#=#=#=#
### CONSTRUTOR ####
###################    

novoLeitor = Leitor('José', 12345, 'jse@gmail.com', 101)
novoLeitor.save()
print(novoLeitor.__repr__())

novoLeitor = Leitor('Rafael', 54321, 'raf.ael@gmail.com', 102)
novoLeitor.save()
print(novoLeitor.__repr__())

novoLeitor = Leitor('Jorge', 23456, 'jorge.m@gmail.com', 103)
novoLeitor.save()
print(novoLeitor.__repr__())

novoLeitor = Leitor('Gabriel', 590, 'gabrielortega590@gmail.com', 590)
novoLeitor.save()
print(novoLeitor.__repr__())

novoLeitor = Leitor('Marcela', 5590, 'marcela590@gmail.com', 550)
novoLeitor.save()
print(novoLeitor.__repr__())

novoLeitor = Leitor('Pedro', 6543, 'pedro.tyssonm@gmail.com', 104)
novoLeitor.save()
print(novoLeitor.__repr__())

novoGerente = Gerente('GERENTE', 1442536, 'biblioteca@support.com', 0)
novoGerente.save()
print(novoGerente.__repr__())

novoLivro = Livros('Cansei de ser trouxa', 'Rafael Lapa Valgas', 'Pearson', 4)
novoLivro.save()

novoLivro = Livros('ADS 2 fase', 'Gabriel', 'Pearson', 8)
novoLivro.save()

novoLivro = Livros('puga algoritmo', 'Carlos', 'LTC', 9)
novoLivro.save()

novoLivro = Livros('Uma vez bebi de mais', 'Rafael Lapa Valgas', 'LTC', 3)
novoLivro.save()

novoLivro = Livros('Concluindo a tarefa de algoritimo', 'Rafael Lapa Valgas', 'Pearson', 1)
novoLivro.save()

novoLivro = Livros('Era uma vez... Que não era nada!', 'Rafael Lapa Valgas', 'Companhia das Letras', 3)
novoLivro.save()

novoLivro = Livros('Cansei dessas Tolices', 'Rafael Lapa Valgas', 'LTC', 4)
novoLivro.save()

novoLivro = Livros('Fim dos meus livros', 'Rafael Lapa Valgas', 'Pearson', 4)
novoLivro.save()


#-----------------------------------

#def start():
#    start__ = False
#    while (start__ == False):
#        menuType = login()
#        start__ = True
#    else:
#        start__ = menu(menuType)
#        if (start__ == False):
#            start()


def start():
    back = bool
    menuType = []
    while (menuType == []): #login
        menuType = login()    
    back = menu(menuType)     #Menu
    if (back == False):       #verifica looping de logoff
        start()
    elif (back == None):      #desliga
        pass
start()

