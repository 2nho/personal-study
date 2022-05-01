function Person(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
}
  
var me = new Person("John", "Smith");
  
console.table(me);

var people = [["John", "Smith"], ["Jane", "Doe"], ["Emily", "Jones"]]
console.table(people);

