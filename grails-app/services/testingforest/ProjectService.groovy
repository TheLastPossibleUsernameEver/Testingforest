package testingforest

import grails.gorm.transactions.Transactional

@Transactional
class ProjectService {

    def get(id){
        Project.get(id)
    }

    def list(){
        Project.list()
    }


    def save(project){
        project.save()
    }

    def delete(id){
        Project.get(id).delete()
    }
}
