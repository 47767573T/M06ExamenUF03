/**
 * Created by 47767573t on 15/03/16.
 */
public class XpathEjemplos {

    //paises en toda la coleccion de factbook
    String query0 = "collection('Factbook.xml')/factbook/record/country";


    //Número de paises de la coleccion
    String query1 = "collection('mondial.xml')/count(/mondial/country)";


    //Toda la informacion sobre un pais llamado "Germany"
    String query2 = "collection('mondial.xml')/mondial/country[name=\"Germany\"]";


    //Número de cantidad de poblacion de un pais llamado "Uganda"
    String query3 = "collection('mondial.xml')/mondial/country[name=\"Uganda\"]/population[last()]/text()";


    //Las ciudades de Perú
    String query4 = "collection('mondial.xml')/mondial/country[name=\"Peru\"]/province/city/name/text()";


    //Cuanta gente vive en shangai
    String query5 = "collection('mondial.xml')/mondial/country/province[name=\"Shanghai\"]/population[last()]/text()";


    //Cual es el codigo de matricula de coche de chipre (@ para invocar el atributo "car_code")
    String query6 ="collection('mondial.xml')/mondial/country[name=\"Cyprus\"]/@car_code";

}
