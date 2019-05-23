/*
Author : Sathyanarayanan
Purpose : This file queries OMDB API based on Movie Name
*/
// http://www.omdbapi.com/?t=terminator&apikey=f4cba32c

def queryomdb() {
    def baseURL = 'http://www.omdbapi.com/'
    def apikey = 'f4cba32c'
    println "Please input Movie Name to Query"
    String movieName = System.in.newReader().readLine().trim()
    //movieName = movieName.toString()
    println "Running Query for " + movieName
    apiOut = new ByteArrayOutputStream()
    apiErr = new ByteArrayOutputStream()
    run = """
    curl '${baseURL}\\?t=${movieName}&apikey=${apikey}'
    """  
    runProc = ['bash', '-c',  run].execute()
    runProc.waitForProcessOutput(apiOut, apiErr)
    
    println "STDOUT " + apiOut
    println "STDERR " + apiErr
    //println run.split(',')
}

queryomdb()