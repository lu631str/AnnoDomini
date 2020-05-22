/*
This Worksheet is supposed to collect and explain several List operations and give examples for their use
This is supposed to be a quick lookup if one of us has to deal with Lists
This does have no effect on the game itself
 */

// List declaration
val list = List(1, 2, 3, 8)
val list2 = 1::2::3::4::Nil

// basic Functions
list.head // 1
list.tail // (2, 3, 8)
list.last // 8

list.length
list.size

// lists are inmutable:
6::list  // puts 6 at the head, but change is only temporarily
list  // is the same as in declaration, because list ar immutable
list(2)  // returns 3, like Array
// list(2) = 3  // throws error, because List is immutable

list match{
  case Nil => 1    // match is basically a switch case
  case h::t => t  // automatically recognizes h as head and t as tail
}
