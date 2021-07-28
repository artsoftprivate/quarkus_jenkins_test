def buildApp() {
    echo "Building version: ${params.VERSION}"
}

def testApp() {
    echo "Testing version: ${params.VERSION}"
} 

def deployApp() {
    echo "Deploying version ${params.VERSION}"
} 

return this
