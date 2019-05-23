/*
Author : Sathyanarayanan
Purpose : This file queries OMDB API based on Movie Name
*/

import groovy.json.JsonSlurper;
import groovy.json.JsonOutput;
import groovy.json.JsonBuilder;

def queryomdb(String whichMovie = movieName) {

    def apikey = 'f4cba32c'
    def apiOut = new ByteArrayOutputStream()
    def apiErr = new ByteArrayOutputStream()

    URL urlBuild = new URL ("http://www.omdbapi.com/?t=${whichMovie}&apikey=${apikey}")
    def movieApiSlurper = new JsonSlurper().parse(urlBuild)
    String movieApiOut = new JsonBuilder(movieApiSlurper).toPrettyString()

        if (movieApiOut =~ "Movie not found!") {
            println "Movie Not Found, Please check the Name you provided :) :)"
            
        }  
        else  {
            println "STDOUT " + movieApiOut
        }  

}

def processinput() {

    println "Please input Movie Name to Query"
    def movieName = System.in.newReader().readLine().trim()
    println "Running Query for " + movieName
    movieName = movieName.replaceAll("\\s", '+')

    queryomdb(movieName)
}
processinput()