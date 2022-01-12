En ITI 1121/1521, nous utilisons  JUnit pour noter automatiquement les
des  laboratoires. Pour  chaque laboratoire,  nous vous  donnerons les
tests qui seront utilisés pour noter votre travail.

Voici les instructions pour lire et exécuter les tests.

Nous  croyons fermement  que vous  pouvez obtenir  toute l'information
dont  vous  avez besoin  simplement  en  lisant  les tests,  sans  les
compiler ni les exécuter.

Par exemple,  la classe Demo  (fichier Demo.java) déclare  une méthode
appelée sum :

    public static int sum(int a, int b) {
        retour a+b ;
    }

La classe TestDemo, déclare deux  méthodes de test pour sum, testSum00
et testSum34. Voici le code source de testSum34 :

    @Test
    public void testSum34() {

        asserEquals(7, Demo.sum(3,4)) ;
        
        note += 0,25 ;
        
    }

Comme vous pouvez le voir,  asserEquals appelle la méthode Demo.sum en
passant les  valeurs 3  et 4.  Si la méthode  renvoie 7,  comme prévu,
l'essai est  une réussite,  et l'étudiant obtient  0,25 point  pour ce
test, sinon, le test échoue et l'étudiant n'obtient rien pour ce test.

Si vous souhaitez  les compiler, notamment pour vous  assurer que tous
les noms sont correctement  orthographiés, voici les instructions pour
le faire.

Ces tests  nécessitent la  version 4  de JUnit.  Vous aurez  besoin de
JUnit 4.13  ou plus élevé.  Ne télécharger pas  la version 5,  car ces
programmes n'ont pas été testés avec cette version.

Dans certains cas, les étudiants auront des boucles infinies dans leur
code. Nous devons donc utiliser des mécanismes de time-out (voyez-vous
pourquoi ?). Ces mécanismes ont été introduits avec la version 4.12 de
JUnit.

Dans cette archive,  nous avons mis des copies  des deux bibliothèques
qui sont nécessaires :

https://search.maven.org/remotecontent?filepath=junit/junit/4.13/junit-4.13.jar
https://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar
 
La façon  la plus simple  de compiler et  d'exécuter les tests  est de
tout mettre dans un dossier (votre code source, nos tests, et les deux
fichiers .jar).

> pwd

/Utilisateurs/turcotte/Desktop/JUnitDemo

> ls -l

ls -l
total 896
   995 12 Jan 10:59 Demo.java
  7027 12 Jan 11:40 README-FR.txt
  6239 17 février 2019 LISEZ-MOI-fr.txt
  3475 12 Jan 11:25 TestDemo.java
  1951 12 Jan 11:08 TestUtils.java
 45024 12 jan 10:30 hamcrest-core-1.3.jar
381765 12 jan 10:30 junit-4.13.jar
 
Ensuite, vous devez compiler les fichiers Java.

Sous macOS, Linux, ou Unix en général :
 
> javac -cp junit-4.13.jar:hamcrest-core-1.3.jar :. TestDemo.java

Sous Windows :
 
> javac -cp "junit-4.13.jar;hamcrest-core-1.3.jar ;." TestDemo.java

Ensuite, on exécute les tests.
 
Sous macOS, Linux, ou Unix en général :
 
> java -cp junit-4.13.jar:hamcrest-core-1.3.jar :. TestDemo

Running TestDemo

******************************************************************
Grade for Demo (out of possible 1.0): 0.5
******************************************************************
Number of tests run: 3
Number of tests that failed: 1

List of failed tests:

testSwap(TestDemo): expected:<1> but was:<0>
	at TestDemo.testSwap(TestDemo.java:91)

Ici, dans  cette démo, on  s'attendait à ce  que l'un des  trois tests
échoue.  Vous  le voyez,  il  vous  dit qu'asserEquals  s'attendait  à
recevoir la valeur 1, mais il a trouvé la valeur 0.

Sous Windows :
 
> java -cp "junit-4.13.jar;hamcrest-core-1.3.jar ;." TestDemo
Running TestDemo

******************************************************************
Grade for Demo (out of possible 1.0): 0.5
******************************************************************
Number of tests run: 3
Number of tests that failed: 1

List of failed tests:

testSwap(TestDemo): expected:<1> but was:<0>
	at TestDemo.testSwap(TestDemo.java:91)

Si vous compilez et exécutez fréquemment des tests JUnit (par exemple,
si  vous voulez  le faire  pour les  laboratoires), alors  vous pouvez
sauvegarder les deux  fichiers .jar à l'emplacement de  votre choix et
définissez  la variable  d'environnement  CLASSPATH  pour les  pointer
(ainsi que le répertoire courant '.').
 
export CLASSPATH=/Users/turcotte/lib/java/junit-4.13/junit-4.13.jar:/Users/turcotte/lib/java/junit-4.13/hamcrest-core-1.3.jar:.

De cette façon, vous n'aurez pas  besoin de spécifier le chemin sur la
ligne de commande lors de la compilation et de l'exécution des tests.
 
> javac TestDemo.java
> java TestDemo

Running TestDemo

******************************************************************
Grade for Demo (out of possible 1.0): 0.5
******************************************************************
Number of tests run: 3
Number of tests that failed: 1

List of failed tests:

testSwap(TestDemo): expected:<1> but was:<0>
	at TestDemo.testSwap(TestDemo.java:91)

Vous  pouvez rendre  la modification  permanente en  ajoutant l'énoncé
'export'  au  fichier .bashrc  qui  se  trouve dans  votre  répertoire
principal (faites attention  lorsque vous éditez ce  fichier, car vous
pourriez  ne plus  avoir  accès  à votre  compte  si  vous faites  une
erreur).

De même, sous Windows, vous pouvez définir la variable d'environnement
CLASSPATH  pour désigner  ces  deux fichiers  .jar.  Le processus  est
similaire  à  ce   que  vous  avez  fait  pour   définir  la  variable
d'environnement Path.

Plus  précisément,   sauvegardons  une  copie  de   junit-4.13.jar  et
hamcrest-core-1.3.jar           dans           le           répertoire
C:\Users\turcotte\Library\Java\JUnit-4.13 (adaptez ceci à votre propre
environnement et goût).

Ensuite, allez  dans le panneau  de contrôle (vous  pouvez typiquement
taper "variable"  dans la boîte  de recherche Cortana et  Windows vous
proposera   l'option  d'édition   des  variables   d'environnement  du
système).  Définissez une  nouvelle variable  appelée CLASSPATH,  dans
notre exemple, le contenu de la variable serait :

"C:\Users\turcotte\Library\Java\JUnit-4.13\junit-4.13.jar;C:\Users\turcotte\Library\Java\JUnit-4.13\hamcrest-core-1.3.jar ;."

Ajustez le chemin en fonction de la configuration de votre ordinateur.

Maintenant,  vous pouvez  compiler et  exécuter les  tests JUnit  sans
spécifier le chemin des bibliothèques de JUnit :

> javac TestDemo.java
> java TestDemo

Vous trouverez des informations complémentaires ici :
 
https://junit.org/junit4
 
Nous espérerons que ces informations vous seront utiles,

Guy-Vincent, Marcel & Mehrdad

Sun Jan 12 12:33:16 2020

