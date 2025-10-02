/**
 * 
 */
/**
 * 
 */
module Reto2 {
	requires xstream;

	opens serializacionXML to xstream;
	opens pruebasJson to xstream;

	exports serializacionXML;
	exports pruebasJson;
}