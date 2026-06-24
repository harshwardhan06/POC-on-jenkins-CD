package com.company.cicd

class DeploymentExecutor implements Serializable {

    def steps

    DeploymentExecutor(def steps) {
        this.steps = steps
    }

    void execute(List<String> apps, Map<String, Map> configs) {

        apps.eachWithIndex { app, index ->

            Map cfg = configs[app]

            steps.echo "================================"
            steps.echo "Priority      : ${index + 1}"
            steps.echo "Application   : ${app}"
            steps.echo "Image Tag     : ${cfg.imageTag}"
            steps.echo "Chart Version : ${cfg.chartVersion}"
            steps.echo "================================"

            steps.sh """
                echo Deploying ${app}
                echo Using image tag ${cfg.imageTag}
                echo Using chart version ${cfg.chartVersion}
            """
        }
    }
}
