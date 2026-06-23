@Library('cicd-shared-lib') _

import com.company.cicd.PriorityManager
import com.company.cicd.DeploymentExecutor

properties([
    parameters([
        choice(
            name: 'PRIORITY_1',
            choices: [
                'NONE',
                'AB',
                'BC',
                'CD',
                'DE'
            ]
        ),
        choice(
            name: 'PRIORITY_2',
            choices: [
                'NONE',
                'AB',
                'BC',
                'CD',
                'DE'
            ]
        ),
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
    ])
])

node {

    def PRIORITY_APPS = []

    stage('Build Priority List') {

        PRIORITY_APPS = PriorityManager.getPriorityList(params)

        echo "Selected Priority Order"

        PRIORITY_APPS.eachWithIndex { app, index ->
            echo "${index + 1} -> ${app}"
        }
    }

    stage('Deploy') {

        def deployer = new DeploymentExecutor(this)

        deployer.execute(PRIORITY_APPS)
    }
}
