package testingforest

import grails.gorm.transactions.Transactional

@Transactional
class ProjectService {

    def get(Long id){
        Project.get(id)
    }

    def list(){
        Project.list()
    }

    def save(Project project){
        project.save()
    }

    def delete(Long id){
        Project.get(id).delete()
    }
    def count(){
        Project.count()
    }
}
