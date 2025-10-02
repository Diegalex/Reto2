/**
 * 
 */
/**
 * 
 */
module Reto2 {
	requires xstream;
	requires java.xml;

	opens serializacionXML to xstream;
	opens pruebasJson to xstream;

	exports serializacionXML;
	exports pruebasJson;
}