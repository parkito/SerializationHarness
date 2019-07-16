@0xe9e172ef0f0049f6;

using Java = import "/java.capnp";

$Java.package("org.capnproto.examples");
$Java.outerClassname("UserModel");

struct User {
  id @0 :UInt64;
  name @1 :Text;
  signature @2 :Data;
  addresses @3 :List(Address);
}

struct Address {
  id @0 :UInt64;
  city @1 :Text;
  population @2 :UInt32;
}