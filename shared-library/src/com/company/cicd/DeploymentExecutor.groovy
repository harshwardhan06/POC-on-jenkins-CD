package com.company.cicd

class DeploymentExecutor implements Serializable {

    def steps

    DeploymentExecutor(def steps) {
        this.steps = steps
    }

    void execute(List<String> apps) {

        apps.each { app ->

            String imageTag =
                ImageTagGenerator.generate(app)

            steps.echo "================================"
            steps.echo "Application : ${app}"
            steps.echo "Image Tag   : ${imageTag}"
            steps.echo "================================"

            steps.sh """
                echo Deploying ${app}
                echo Using tag ${imageTag}
            """
        }
    }
}
