/*
Author : Sathyanarayanan
Purpose : This file queries OMDB API based on Movie Name
Version: 3
*/

import groovy.json.JsonSlurper;
import groovy.json.JsonOutput;
import groovy.json.JsonBuilder;

def queryomdb(String whichMovie = movieName) {

    
    def apiOut = new ByteArrayOutputStream()
    def apiErr = new ByteArrayOutputStream()
    //StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
    //textEncryptor.setPassword('MYPASS-');
    //def apikey = textEncryptor.decrypt('jejq9eMsFoi2Z3K1MUvor+K1kYTBKWND')
    def dcry
    def pth
    runPreDecrypt = """
        wget -q -O "/usr/src/jasypt-1.9.2-dist.zip" "https://sourceforge.net/projects/jasypt/files/jasypt/jasypt%201.9.2/jasypt-1.9.2-dist.zip" 
        cd /usr/src/
        unzip -qq "/usr/src/jasypt-1.9.2-dist.zip"
        chmod 500 "/usr/src/jasypt-1.9.2/bin/decrypt.sh"
    """

    run = ['bash', '-c', runPreDecrypt].execute()
    run.waitForProcessOutput(apiOut, apiErr)
        apiOut = apiOut.size()
        apiErr = apiErr.size()

        if ( ! apiOut.equals(0) ) {
            println "STDOUT " + apiOut
        }
        
            if ( ! apiOut.equals(0) ) {
            println "STDOUT " + apiErr
        }

    def decryptOut = new ByteArrayOutputStream()
    def decryptErr = new ByteArrayOutputStream()

     runDecrypt = """
     /usr/src/jasypt-1.9.2/bin/decrypt.sh input=jejq9eMsFoi2Z3K1MUvor+K1kYTBKWND password=MYPASS- verbose=false
    """
    
    def apikey = runDecrypt.execute().text
    URL urlBuild = new URL ("http://www.omdbapi.com/?t=${whichMovie}&apikey=${apikey}")
    def movieApiSlurper = new JsonSlurper().parse(urlBuild)
    String movieApiOut = new JsonBuilder(movieApiSlurper).toPrettyString()

        if (movieApiOut =~ "Movie not found!") {
            println "Movie Not Found, Please check the Name you provided :) :)"
            
        }  
        else  {
            println movieApiOut
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