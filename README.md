# Mastering Spring Framework 6 / Spring Boot 3 using Java

<div id="user-content-toc">
  <ul style="list-style: none;">
    <summary>
      <h2>Tight coupling</h2>
    </summary>
  </ul>
</div>

Coupling is how much effort is needed , when changing something. Example of tight coupling is, let say we have 3 games and these games are called and run in gamer class. So, if everytime to run each game if we have to change the gamer class to call that particular game, it not correct right. This is called tight coupling. We always have to keep our code loosely coupled. To overcome this problem we can use "Interface".

Ref : [Loose Coupling Game App using Interface](https://github.com/lakshmir1098/Spring6-with-Java/tree/master/working-directory/MasteringSpring/src/main/java/com/learnings/MasteringSpring/LooselyCoupling)

|                                         Tight Coupling                                         |                                         LooseCoupling                                          |
| :--------------------------------------------------------------------------------------------: | :--------------------------------------------------------------------------------------------: |
| ![](https://github.com/lakshmir1098/Spring6-with-Java/blob/master/images/tight%20coupling.png) | ![](https://github.com/lakshmir1098/Spring6-with-Java/blob/master/images/Loose%20coupling.png) |

---

<div id="user-content-toc">
  <ul style="list-style: none;">
    <summary>
      <h2>Steps in Launching Java Spring </h2>
    </summary>
  </ul>
</div>

Steps to Launch a Spring Application:

Ref : [SpringIntro](https://github.com/lakshmir1098/Spring6-with-Java/tree/master/working-directory/MasteringSpring/src/main/java/com/learnings/MasteringSpring/SpringIntro)

1. Create a configuration class with `@Configuration` annotation.

   ```java
   @Configuration
   public class HelloWorldConfiguration
   ```

2. In Java main class, launch a Spring Context by, creating new `ApplicationConfigApplicationContext` for the configuration class above created.

   ```java
   var context =
   new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
   ```

3. Create Beans to be managed by Spring in the configuration class.

   ```java
   @Bean
   public String name() {
   	return "Ranga";
   }
   ```

4. Retrieve the ouput of this bean in our main class by calling the Beans.

   ```java
    System.out.println(context.getBean("name"));
   ```

---

<div id="user-content-toc">
  <ul style="list-style: none;">
    <summary>
      <h2>3 ways of caling with Beans </h2>
    </summary>
  </ul>
</div>

1. Directly adding values to be returned

   ```java
   record Person (String name, int age, Address address) { };
   record Address(String firstLine, String city){ };

   @Bean
   public Person person1() {
   	return new Person("Ravi", 20, new Address("Main Street", "Utrecht"));
   }

   System.out.println(context.getBean("person1"));
   System.out.println(context.getBean(Address.class));
   ```

2. Calling Bean to return values also called as **wiring with Method calls**

   ```java
   record Address(String firstLine, String city){ };

   @Bean
   public String name() {
   	return "Ranga";
   }

   @Bean
   public int age() {
   	return 15;
   }


   @Bean
   public Person person2MethodCall() {
   	return new Person(name(), age(), address2()); //name, age
   }

   @Bean(name = "address2")
   public Address address2() {
   	return new Address("Motinagar", "Hyderabad");
   }
   System.out.println(context.getBean("person2MethodCall"));
   System.out.println(context.getBean("name"));
   ```

3. Passing Bean name as param also called as **wiring with Parameters**

   ```java
   record Address(String firstLine, String city){ };

   @Bean
   public String name() {
   	return "Ranga";
   }

   @Bean
   public int age() {
   	return 15;
   }

   @Bean
   public Person person3Parameters(String name, int age, Address address3) {
   	//name,age,address3
   	return new Person(name, age, address3); //name, age
   }

   @Bean(name = "address3")
   public Address address3() {
   	return new Address("Motinagar", "Hyderabad");
   }

   System.out.println(context.getBean("person3Parameters"));
   System.out.println(context.getBean("address3"));
   ```

#### To get list of all the beans :

```java
Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
```

#### How to overcome multiple Bean of same type error:

Example:
`No qualifying bean of type 'com.learnings.MasteringSpring.SpringIntro.Configuration.Person' available: expected single matching bean but found 3: person1,person2ndway,person3rdway`

Ans:

- By making one of the Bean primary so the Bean mentioned as `@Primary` will be given importance.
- We can also use `@Qualifier` and give an unique name

---

<div id="user-content-toc">
  <ul style="list-style: none;">
    <summary>
      <h2>Spring Container/ IOC Container/ Spring Context</h2>
    </summary>
  </ul>
</div>

Manages Spring Beansand their lifecycle.

There are 2 types of Container:

- **Bean Factory** - Basic Spring Container
- **Application Context** - Used for enterprise-specific features like web services, REST API and, microservices

### Difference between Java Bean / POJO / Spring Bean

- **Spring Bean** - What we have used so fare are called Spring Beans where Spring manages the Java Objects.
- **POJO** - Is a simple Java class with just the variables and `toString` Method
- **Java Bean** - This class should follow 3 EJB contraints

  - Have public default no-arg constructor
  - Includes getter and setter methods for their properties
  - Implements `java.io.Serializable`

---

<div id="user-content-toc">
  <ul style="list-style: none;">
    <summary>
      <h2>How to make Spring create Beans/ objects automatically for us</h2>
    </summary>
  </ul>
</div>
Ref : [Game Runner App changes](https://github.com/lakshmir1098/Spring6-with-Java/blob/master/working-directory/SpringNextStep03/src/main/java/com/learnings/SpringNextStep/GameConsoleRunnnerMain.java)

1. Remove the configuraiton class file and make the main class with `@Configuration`.
2. Declare `@Component` on Gam01 or Game02 class and also for GameRunnner class
3. Add `@ComponenetScan("compenet_path)` to the main class (Configuration class)

---

<div id="user-content-toc">
  <ul style="list-style: none;">
    <summary>
      <h2>Dependency Injection</h2>
    </summary>
  </ul>
</div>
Ref : [All 3 types with eg](https://github.com/lakshmir1098/Spring6-with-Java/tree/master/working-directory/SpringNextStep03/src/main/java/com/learnings/SpringNextStep/DependencyInj)

### Types of DI:

1. Constructor-based (used so far)

```java
    @Component
    class Engine {
        public void start() {
            System.out.println("Engine started!");
        }
    }

    @Component
    class Car {
        private final Engine engine;

        // Dependency injected via constructor
        @Autowired
        public Car(Engine engine) {
            this.engine = engine;
        }

        public void drive() {
            engine.start();
            System.out.println("Car is moving!");
        }
    }

    public class ConstructorDI {
        public static void main(String[] args) {
                var context = new AnnotationConfigApplicationContext();
                Car car = context.getBean(Car.class);
                car.drive();
        }
    }
```

2. Setter-based

```java
  @Component("Engine2")
  class EngineS {
          public void start() {
                  System.out.println("Engine2 started!");
          }
  }

  @Component("Car2")
  class CarS {
          private EngineS engine;

          // Dependency injected via setter
          @Autowired
          public void setEngine(EngineS engine) {
                  this.engine = engine;
          }

          public void drive() {
                  engine.start();
                  System.out.println("Car2 is moving!");
          }
  }

    @Configuration
    @ComponentScan
    public class SetterDI {
            public static void main(String[] args) {
                    var context = new AnnotationConfigApplicationContext(SetterDI.class);

                    CarS car = context.getBean(CarS.class);
                    car.drive();

                    context.close();
            }
    }
```

3. Field-based

```java
  @Component("Engine3")
class EngineF {
        public void start() {
                System.out.println("Engine3 started!");
        }
}

@Component("Car3")
class CarF {
        @Autowired // Dependency injected directly into the field
        private EngineF engine;

        public void drive() {
                engine.start();
                System.out.println("Car3 is moving!");
        }
}

@Configuration
@ComponentScan
public class FieldDI {
      public static void main(String[] args) {
              var context = new AnnotationConfigApplicationContext(FieldDI.class);

              CarF car = context.getBean(CarF.class);
              car.drive();

              context.close();
      }
}
```

### BeanScope
 There are 2 bean scope  they are 
 1. Singleton scope - when a class is singleton scoped and when its bean is called multiple times, it will create same instance.
2.  Prototype scope - when a class is prototype scoped andwhen its bean called multiple times, it creates multiple instamces.

Other than this for webAppliction using HTTP request has few scopes. They are,
1. Request scope
2. Session scope
3. Application scope
4. WebSocket scope

### XML Configuration
Can be done and read by,
```java
var context = new ClassPathXmlApplicationContext("contextconfig.xml");
```

<h4> How to create a simple RESTAPI call </h4>
    1. Create a controller class  with `@RestController` having  `@RequestMapping` to an API on a method

```java
        @RestController
        public class Controller
        {
                @RequestMapping("/courses")
                public List <Courses> getCourse(){
                        return Arrays.asList(
                                new Courses(1, "AWS", "Udemy"),
                                new Courses(2,"Microservice","Udemy")
                        );
                }
        }
```
2. Now we have a List of Courses so what is courses. Its a user defined datatype of List. Now we have to create a courses class  and define it.

```java
public class Courses {
        private long id;
        private String subject;
        private String source;

        public Courses(long id, String subject, String source) {
                this.id = id;
                this.subject = subject;
                this.source = source;
        }

        public long getId() {
                return id;
        }

        public String getSubject() {
                return subject;
        }

        public String getSource() {
                return source;
        }

        @Override
        public String toString() {
                return "Courses{" +
                        "id=" + id +
                        ", subject='" + subject + '\'' +
                        ", source='" + source + '\'' +
                        '}';
        }
}
```
3. Then just run main class and open https:\\localhost:8080\courses
