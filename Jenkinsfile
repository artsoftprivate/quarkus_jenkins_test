def gv

pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    environment {
        VERSION = '1.0.0'
        SERVER_CREDENTIALS = credentials('a0736a04-c399-4450-a094-2abb0c1ed094')
    }
    parameters {
        choice(name: 'VERSION', choices: ['1.0.0', '1.1.0', '1.2.0'], description: 'Version of webapp')
        booleanParam(name: 'executeTests', defaultValue: true, description: 'Testing switch ON/OFF')
    }
    stages {
        stage("init") {
            steps {
                script {
                    // Loads the file with name 'script.groovy' with is present in same folder!
                   gv = load "script.groovy"
                }
            }
        }
        stage("build") {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage("test") {

            when {
                expression {
//                  Also possible:  params.executeTests (without "== true") ...
                    params.executeTests == true
                }
            }
//             when {
//                 expression {
//                     params.executeTests
//                 }
//             }
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    gv.deployApp()
//                     withCredentials([usernamePassword(credentials: 'a0736a04-c399-4450-a094-2abb0c1ed094', usernameVariable: USER, passwordVariable: PWD)]) {
//
//                     }
                }
            }
        }
    }   
    post {
        always {
            // Will be executed ALWAYS!
            echo "Always executed!"
        }
        success {
            // Will be executed only in case of SUCCESS!
            echo "Executed! - SUCCESS"
        }
        failure {
            // Will be executed only in case of FAILURE!
            echo "Executed! - FAILURE"
        }
    }
}
