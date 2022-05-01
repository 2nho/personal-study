let user = "";

function greet() {
  console.count(user);
}

user = "bob";
greet();
user = "alice";
greet();
greet();
console.count("alice");
console.countReset("alice");
greet();
