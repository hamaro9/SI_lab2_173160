Софтверско инженерство – лабораториска вежба 2
**1. Група на код: 5**
**2. Слика од CFG**
![CFG](https://drive.google.com/file/d/1V8NfO_nvbB6WMCOLpDCfKyV31-9qDLUZ/view?usp=sharing)

**3. Пресметка за цикломатската комплексност на функцијата:**

Cyclomatic complexity = E-N+2  = 19-16+2 = 5

N=16 – во графот има 16 јазли

E=19 – во графот има 19 рабови

**4. Тест случаи според Every Statement criteria и Every Path criteria:**

- Every Statement Criteria – Овој критериум се покрива со следните два тест случаи:

list= [0,0,#,0] ; Во овој случај се поминуваат јазлите: 1,2,3,5,6,7,9,13,15,16,6,7,9,11,13,14,15,16, 6,7,10,16, 6,7,9,11,12,13,15,16,6,8

Овој тест случај ги поминува сите јазли освен 4, кој фрла IllegalArgumentException.

За да се покрие и овој statement, го правиме и следниот тест:

list = [] ; Во овој случај ќе се исполни условот на if (list.size() <= 0), бидејќи е празна низа.

- Every Path Criteria – Овој критериум се покрива со следните тест случаи:

1,2,5 => Влезот е празна низа, се фрла IllegalArgumentException

1,2,3,5,6,7,10,16,8 => Влезот има само симбол за бомба

1,2,3,5,6,7,9,11,13,15,16,6,8 => Влезот има само број 0

1,2,3,5,(6,7,9,11,13,15,16),6,7,9,11,13,14,15,16,6,7,10,16,6,8 => Влезот има симбол за бомба на крај

1,2,3,5,6,7,10,16,6,7,9,11,12,13,15,16,(6,7,9,11,13,15,16),6,8 => Влезот има симбол за бомба на почеток

1,2,3,5,(6,7,9,11,13,15,16),6,7,9,11,13,14,15,16,6,7,10,16,6,7,9,11,12,13,17,16,(6,7,9,11,13,15,16),6,8 => Влезот има симбол за бомба во средина, меѓу нулите

1,2,3,5,6,7,10,16,6,7,9,11,12,13,15,16,(6,7,9,11,13,15,16),6,7,9,11,13,14,15,16,6,7,10,16,6,8 => Влезот има симболи за бомба на краевите
1,2,3,5,6,7,10,16,6,7,9,11,12,13,14,15,16,6,7,10,16,6,8 => Влезот има симболи за бомба на краевите, и има една нула помеѓу нив

Останатите патеки логички е невозможно да се добијат, и затоа не се искористени за тестирање.

**5.Unit тестовите се напишани во JUnit 4**
За повеќето од нив, искористив две инстанци од типот на ArrayList: тест низа која се прима како влезен аргумент во функцијата (testArray), како и резултантна низа на тоа што би требало да се добие на излез од самата функција (resultArray).

Со користење на функцијата од JUnit assertEquals, се споредува излезот од функцијата која го прима testArray  на влез, и resultArray.

Пример: assertEquals(siLab2.function(testArray),resultArray);
За тестирање на Exception, го искористив Expected параметарот на анотацијата @Test на следниот начин:

@Test(expected = IllegalArgumentException.class)

Во самиот тест е искористен случај во кој ќе се фрли тој IllegalArgumentException (пр. Празна низа), и самиот тест автоматски поминува како точен, бидејќи е очекувано да се фрли Exception од таков тип.