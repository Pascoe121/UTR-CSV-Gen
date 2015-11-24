package hmrc
import scala.util._

object Main  {
    class Generator
  {
    private var weightArray = Array(6,7,8,9,10,5,4,3,2)
    private var chkArray = Array(2,1,9,8,7,6,5,4,3,2,1)
    private var iArray = new Array[Int](9)

    def generator(): Unit = {
      var row = 0
      var first = 0

      println("UTR,Forename,Surname,Business,NINO,VRN,Fwempref,Pcde,Hsenum,Hsename,FullAddress,AgentCode,Telephone,BankAccount,SortCode,RollNumber,ClaimAmount,Date,Notes,Status,Referer,Reason,Identifier,WatchlistID,ReviewDate")
      while(row<200000)
        {
          row += 1
          var newRow = java.lang.Integer.toString(row)
          var rn = new Random()
          var sum = 0

          while(newRow.length < 6)
            {
              newRow = "0" + newRow
            }

          while(newRow.length < 9)
            {
              newRow = rn.nextInt(10) + newRow
            }

          for(i <- 0 until newRow.length)
            {
              iArray(i) = newRow.charAt(i) - 0
            }

          for(i <- 0 until iArray.length)
            {
              iArray(i) *= weightArray(i)
              sum += iArray(i)
            }

          sum = sum%11

          var chk = chkArray(sum)

          var full = chk + newRow

          println(full + ",Forename,Surname,Business,NINO,VRN,Fwempref,Pcde,Hsenum,Hsename,FullAddress,AgentCode,Telephone,BankAccount,SortCode,RollNumber,ClaimAmount,Date,Notes,Status,Referer,Reason,Identifier,WatchlistID,ReviewDate" )

          
        }
    }


  }


  def  main (args: Array[String]){

    val gen = new Generator
    gen.generator()

  }

}

