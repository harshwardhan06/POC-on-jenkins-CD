package com.company.cicd

class PriorityManager implements Serializable {

    static List<String> getPriorityList(def params) {

        List<String> priorities = []

        if(params.PRIORITY_1 != 'NONE')
            priorities.add(params.PRIORITY_1)

        if(params.PRIORITY_2 != 'NONE')
            priorities.add(params.PRIORITY_2)

        if(params.PRIORITY_3 != 'NONE')
            priorities.add(params.PRIORITY_3)

        return priorities.unique()
    }
}
