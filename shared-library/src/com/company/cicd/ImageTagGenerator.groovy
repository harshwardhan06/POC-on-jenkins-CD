package com.company.cicd

class ImageTagGenerator implements Serializable {

    static String generate(String application) {

        return "image-${application.toLowerCase()}"
    }
}
