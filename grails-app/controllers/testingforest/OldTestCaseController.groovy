package testingforest

class OldTestCaseController {
    def delete() { 
       def date=new Date()
        //180 days ~ 6 months
       date =date.minus(180)
       def query = TestCase.where {
           lastUpdated<date
       }
       int total = query.deleteAll() 
       def response_text=total+" old testcases were removed."
       render(status: 200, text: response_text)
    }
}
