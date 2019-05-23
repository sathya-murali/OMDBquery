/*
Author : Sathyanarayanan
Purpose : This file queries OMDB API based on Movie Name
*/
// http://www.omdbapi.com/?t=terminator&apikey=f4cba32c


def queryomdb(String whichMovie = movieName) {

    def baseURL = 'http://www.omdbapi.com/'
    def apikey = 'f4cba32c'
    def apiOut = new ByteArrayOutputStream()
    def apiErr = new ByteArrayOutputStream()

    run = """
    curl '${baseURL}\\?t=${whichMovie}&apikey=${apikey}'
    """  
    runProc = ['bash', '-c',  run].execute()
    runProc.waitForProcessOutput(apiOut, apiErr)
        if (apiOut =~ "Movie not found!") {
            println "Movie Not Found, Please check the Name you provided :) :)"
            
        }  
        else  {
            println "STDOUT " + apiOut
            println "STDERR " + apiErr
        }  
    
    
    //println run.split(',')
}

def processinput() {

    println "Please input Movie Name to Query"
    def movieName = System.in.newReader().readLine().trim()
    //movieName = movieName.toString()
    println "Running Query for " + movieName
    movieName = movieName.replaceAll("\\s", '+')

    queryomdb(movieName)
}
processinput()