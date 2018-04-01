# JSONParser
Implementing a JSON parser using recursive descent parser by having a LL(1) grammar.
Formal Specification of grammer was taken from http://www.ietf.org/rfc/rfc4627.txt

## Usage
Object object = bootstrap.Parser.parse(jsonText,object.class);

## To Do
JSON arrays are converted to List<?> Objects and java arrays are not supported.
Support for Java arrays is in progress
