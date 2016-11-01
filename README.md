PlantUML Springboot server
==========================
Install [Graphviz](http://www.graphviz.org/).

Build and Start the server:

    $ mvn spring-boot:run

Then if you open this README-file in a Markdown editor, like [MacDown](http://macdown.uranusjr.com/), an UML image shall appear between the horizontal lines below, when this page is reloaded:

* * *

#### Use Case Diagram
![Use Case Diagram](http://localhost:8080/uml?script=
@startuml;
skinparam monochrome true;
left to right direction;
actor User;
actor Admin;
rectangle system {
  User-->(UC1);
  Admin-->(UC1);
}
@enduml;
)

#### Class Diagram
![Class Diagram](http://localhost:8080/uml?script=
@startuml;
skinparam monochrome true;
package alpha {
  class A{
    length:double;
    doit():void;
  }
  class B;
  class C;
  A <|-- B;
  B o--"dees\\n0..n" D:knows >;
  D *-- C;
}
package beta {
  class D;
  interface E{
    notify(event:Event):void;
  }
  class Event;
	C --> alpha.A;
	E <|.. D;
	E..> Event;
}
@enduml;
)

* * *

See [PlantUML](http://plantuml.com/) for more information about syntax.

**Note**: a difference compared to vanilla PlantUML syntax is that each line must be terminated with the character ___;___


Docker
------
It is possible to build a docker image:

  $ mvn clean package docker:build
  $ docker run -d --name plant-uml -p 19180:8080 joelabs/plant-uml-springboot-server:1.0.0
