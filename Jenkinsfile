@Library('cicd-shared-lib') _

import com.company.cicd.PriorityManager
import com.company.cicd.DeploymentExecutor

pipeline {

    agent any

    parameters {

        choice(
            name: 'PRIORITY_1',
            choices: [
                'NONE',
                'AB',
                'BC',
                'CD',
                'DE'
            ]
        )

        choice(
            name: 'PRIORITY_2',
            choices: [
                'NONE',
                'AB',
                'BC',
                'CD',
                'DE'
            ]
        )

        choice(
            name: 'PRIORITY_3',
            choices: [
                'NONE',
                'AB',
                'BC',
                'CD',
                'DE'
            ]
        )
    }

    stages {

        stage('Build Priority List') {

            steps {

                script {

                    PRIORITY_APPS =
                        PriorityManager.getPriorityList(params)

                    echo "Selected Priority Order"

                    PRIORITY_APPS.eachWithIndex { app,index ->

                        echo "${index+1} -> ${app}"
                    }
                }
            }
        }

        stage('Deploy') {

            steps {

                script {

                    def deployer =
                        new DeploymentExecutor(this)

                    deployer.execute(PRIORITY_APPS)
                }
            }
        }
    }
}
