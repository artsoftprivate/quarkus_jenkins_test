def checkOut() {
    echo "----------- Start of CHECKOUT / version: ${params.VERSION} -----------------------------------"
    git credentialsId: 'GITHUB_PRIVATE', url: 'https://github.com/artsoftprivate/quarkus_jenkins_test'
}

def buildApp() {
    echo "----------- Start of BUILDAPP / version: ${params.VERSION} -----------------------------------"
}

def testApp() {
    echo "----------- Start of TESTAPP / version: ${params.VERSION} -----------------------------------"
} 

def deployApp() {
    echo "----------- Start of DEPLOYAPP / version: ${params.VERSION} -----------------------------------"
} 

return this
