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
| ![](https://github.com/lakshmir1098/MasterSB3andSF6withJava/blob/master/images/tight%20coupling.png) | ![](https://github.com/lakshmir1098/MasterSB3andSF6withJava/blob/master/images/Loose%20coupling.png) |

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

1.  have a project generated and dowloanded from spring intializer with  __spring web dependency__
2. Create a controller class  with `@RestController` having  `@RequestMapping` to an API on a method

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
3. Now we have a List of Courses so what is courses. Its a user defined datatype of List. Now we have to create a courses class  and define it.

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

### Hibernate configuration
1. Create a project with H2 dependency added
2. In `application.properties` file enable h2console using  `spring.h2.console.enabled=true`
3. Run the server to get JDBC URL/ database source url and then add it to `application.properties` as  `spring.datasource.url=jdbc:h2:mem:5cc821bf-7ca0-4a44-89db-18e68177bfcf`
4. Now go to http://localhost:8080/h2-console/ and login. Here any quries can be written and this same like a SQL database.
5. Create aSQL file under src\main\resources

### Configuring H2 DB:
* By default sring provide application.properties file to methion the dependency configuration
* We can also use application.yml (Both are same only the format we descibe is different)
* YML is important as now-a-days they are used by cloud providers like AWS , Azure
  and are used in Docker, Kubernetes for Microservices


So what are configurationsfor H2 DB?
```spring.datasource.url=jdbc:h2:mem:testdb (.properties format)
spring:
  datasource:
  driverClassName:org.h2.Driver  (.yml format)
  username: sa
  password: ' '
h2:
  console:
  enabled: true
jpa:
  database-platform: org.hibernate.dialect.H2Dialect
hibernate:
  ddl-auto: update
  show-sql: true   
```
This is the H2 url details on the path to H2 login page with credentials Telling spring to enable H2 console Telling SpringBoot to not create new database instead update the DB with data
  on evey run or update

### Creating RestAPI using @RestController
* Create a controller class and mark the class as @RestController
* Create an Method inside the class and mention the path
  something like \path with @GetMapping or @RequestMapping
* Now start the server and now the path for localhost ad 8080 port
  will show what e have given in the method we created.


  @RequestMapping:
  General Purpose: It can handle all HTTP methods (GET, POST, PUT, DELETE, etc.).
  Versatile: You can specify the HTTP method using the method attribute, allowing you to map to different methods based on your needs.
  Class-Level or Method-Level: It can be applied at both the class and method level.
  Example: @RequestMapping(value="/products", method = RequestMethod.GET).

  @GetMapping: Specific to GET: It is specifically designed for handling HTTP GET requests.
  Simplified: It's a shorthand for @RequestMapping(method = RequestMethod.GET), making it more concise and readable when dealing with GET requests.
  Method-Level: It's typically used at the method level.
  Example: @GetMapping("/products")

### Lets see, how to create table from Java project into SQL (Entity Mapping)
1. Under main/resources create schema.sql. Here is where you define your tables "create table query". This will be
   reflected in h2-console as we are using H2 dialect now.
2. Create entity package and define all the table columns as entity in a Java class.
   TIP: If any colum is present in all the tables like created_date,created_by you can define them as BaseEntity
   Make sure entity name is same as column name
   Eg: if column name is created_date then entity name should be createdDate
   FUN FACT: Add @Column(updatable=false) in createdAt and createdBY while,
   @Column(insertable=false) for updatedAt, updatedBy

### Java project workflow:
1. Create schema.sql under resources and define your tables.
2. Create Entity  with @Entity for each table defining all coulmns of the table and
   if need BaseEntity for common columns.
3. Create repo with @Repository for each table and extend it to JpaRepo with respective entity class
4. Create DTO classes for the tables with @Data annotation and
   also generic ResponseDTO and ErrorDTO for the status code and message once API is called
5. Create service class  as interface and declare your methods (paramterized with respective DTO class)
   that  will be defined in the imlementation class next.
6. Before the implementation class we have to have controller class where we have our API path.
   This should start with @RestController and @RequestMapping with base path (Eg: \accounts)
7. Inside controller create as much methods as you need  with the @_Mapping  
   that has sub unique api path that exceutes the method (Eg: \create and method name: createAccount).
   Here methods  get the @RequestBody from respective DTO class and returns the ResponseEntity with staus_code and status_msg from
   ResponseDTO and/or ErrorDTO.
   If needed, introduce constant class with public static final constants that will
   give custom message for each error/ http response code.
8. Now comes imlementation class with @Service and imports methods declared in the service class and autowire the
   repository classes. Here is where business logic is written.
9. Now we have to create Mapper class that connects entity class and DTO classes by getting from entityclass
   and setting it to DTO class and viceversa [Important Step].
   
NOTE:
    In all class make sure to add @Getter, @Setter, @AllArgsConstructor, @NoArgsConstructor except for DTO class
    as @Getter, @Setter and few more methods are declared  by @Data annotation itself.

### Making EntityClass(table) interact with Database [sending data]):
-> Create an Interface and name it with @Repository annotation
-> extend the interface with JPARepository<EntityClass, PK dataType>,
for Spring Boot to automatically provide the implementation like CURD operations at runtime.
-> Create DTO classes and add only the fields  that needs to be visible to clients
-> Now we come to controller for API path mapping and creating  different methods for each API to  be called
-> The for business logic create service class and implementation class. (see details in Java project workflow)
-> Then mapper class to create connection between entity and dto class

#### What is DTO
Data Transfer Object
Allows you to transfer data between different parts of the application.
DTO contains data as obnjects and no business logic

Advantage:
1. Batch up multiple piece of data into single object
   which reduce no. of request and network traffic
2. Easy to change the serialization format like JSON, text or yml of
   providing data on request and this serialization logic is ecapsulated
3. DTO decouples presentation layer from data access layer

Understanding : From application you dont want to send all the details to the client like UUID
and so as to mask or encapsulate the unessary data and to combine different objects to an
understandable (how usomter wants like combinigs multiple objects as one) objects. We use DTOnderstanding : From application you dont want to send all the details to the client like UUID
and so as to mask or encapsulate the unessary data and to combine different objects to an
understandable (how usomter wants like combinigs multiple objects as one) objects. We use DTO

### Important annotations 
@MappedSuperClass

@Coulum(updateble=false)

@Column(insertable=false)

@Entity   @Table(name = "table_name")

@Id

@GeneratedValue(strategy = GenerationType.AUTO)

@GenericGenerator(name = "uuid2", strategy = "uuid2")    Marking a class as entity for Spring. This is an equivalent class to a table in DB It tells this class acts as asuperclass for all my entities to Spring JPA This is not needed until the table_name and className are same.
otherwise we have explicity mention table name like this to map to the table Saying, its the Primarykey  This annotation is used to specify how the primary key should be generated.
Options are : Auto, Identity, Sequence, Table This is specific to Hibernate and allows you to define custom generator strategies
apart from theabove options for GeneratedValue


Lombok Annotations:

@Getter

@Setter

@ToString

@Data

@AllArgsConstructor

@NoArgsConstructor 

Validation Annotations: Under jakarta.validation.constraints

@NotEmpty(message ="to show when customer send nulll value") 