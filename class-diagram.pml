@startuml

enum AnimalTypes {
    LION
    MAGPIE
}

enum CommandTypes {
    MANAGE
    VISIT
    START
    STATS
    EXIT
    USER
}

interface Searchable {
    + isMatch() : boolean
    + getInformation() : String
}

interface Comparable {
    + compareTo() : int
}

class Animal {
- {static} animalCount : int
- name : String
- sound : String
- id : String
- type : AnimalType
- isTame : boolean
- happiness : int

+ {static} getAnimalCount() : int
+ {static} setAnimalCount() : int
+ getType() : AnimalType
+ getName() : String
+ getSound() : String
+ getId() : String
+ getIsTame() : boolean
+ setIsTame() : void
+ getHappiness() : String
+ setHappiness() : void
+ pet() : void
+ receiveTreat() : void
+ hasMatch() : boolean
+ compareTo() : int
+ toString() : String
}

class Lion {
- isSleeping : boolean
+ isSleeping() : boolean
}

class Magpie {
- isFlying : boolean
+ isFlying() : void
+ receiveTreat() : void
+ toString() : String
}


abstract class Commands {
    - scanner : Scanner
    - name : String
    - commands : String[]
    - nextCommands : CommandTypes
    + getNextCommands() : CommandTypes
    + setNextCommands() : void
    + printMessage() : void
    + printGreeting() : void
    + printCommands() : void
    + getIntegerInput() : int
    + getStringInput() : String
    + {abstract} run() : void
}

class HomeCommands {
    + runCommands() : void
}

class StatsCommands {
    + runCommands() : void
}

class UserCommands {
    - user : User
    + getUser() : User
    + runCommands() : void
}

class ManageCommands {
    - user : User
    + runCommands() : void
}

class VisitCommands {
    - user : User
    + runCommands() : void
}

class User {
    - name : String
    - TreatCount : int
    - score : int
    + getName() : String
    + getTreatCount() : int
    + setTreatCount() : void
    + getScore() : int
    + setScore() : void
    + hasTreatsLeft() : boolean
    + decrementTreats(): void
    + incrementScore(): void
    + hasMatch() : boolean
    + toString() : String
}

class Zoo {
    - {static} zoo : List<Animal>
    + {static} getZoo : List<Animal>
    + {static} getAnimalByIndex() : Animal
    + {static} sortAnimals() : List<Animal>
    - {static} getRandomName() : List<Animal>
}

Magpie <|-- Animal
Lion <|-- Animal

HomeCommands <|-- Commands
StatsCommands <|-- Commands
UserCommands <|-- Commands
ManageCommands <|-- Commands
VisitCommands <|-- Commands

Animal <|.. Comparable
Animal <|.. Searchable
User <|.. Searchable

ManageCommands o-- User
VisitCommands o-- User

StatsCommands -- Zoo
VisitCommands -- Zoo
ManageCommands -- Zoo

Animal "0.. *" --* "1" Zoo : < contains
@enduml
