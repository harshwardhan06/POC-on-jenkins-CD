package com.company.cicd

class AppConfigResolver implements Serializable {

    static Map<String, Map> resolveAll(List<String> apps, def params) {

        Map<String, Map> resolved = [:]

        apps.each { app ->

            String customTag    = params["${app}_custom_image_tag"]
            String imageTag      = params["${app}_image_tag"]
            String currentChart  = params["${app}_current_chart_version"]
            String chartVersion  = params["${app}_chart_version"]

            String finalImageTag =
                customTag?.trim() ?:
                imageTag?.trim() ?:
                ImageTagGenerator.generate(app)

            String finalChartVersion =
                (currentChart && !currentChart.toString().startsWith('Not deployed'))
                    ? currentChart
                    : (chartVersion ?: 'default')

            resolved[app] = [
                imageTag    : finalImageTag,
                chartVersion: finalChartVersion
            ]
        }

        return resolved
    }
}
