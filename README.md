# JSONParser
Implementing a JSON parser using recursive descent parser by having a LL(1) grammar.
Formal Specification of grammer was taken from http://www.ietf.org/rfc/rfc4627.txt

## Usage
Object object = bootstrap.Parser.parse(jsonText,object.class);

## Support
Numeric types: short, byte, int, long, float, double <br />
Booleans <br />
String <br />
List <br />
Custom Objects created by any combination of these following JSON spec

## To Do
JSON arrays are converted to List<?> Objects and java arrays are not supported.
Support for Java arrays is in progress
