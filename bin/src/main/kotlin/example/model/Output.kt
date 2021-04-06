package example.model

import java.util.*
import java.text.SimpleDateFormat

open class Output {
  companion object X {
    var content = mutableMapOf<Long, String>()
  }

  fun getCount() :Long {
    return X.content.size.toLong()
  }

  fun insertTime(){
    val calendar :Calendar = Calendar.getInstance()
    //Returns current time in millis
    val key :Long = calendar.getTimeInMillis()

    val time :String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime())

    if (!X.content.containsKey(key))
    {
        X.content[key] = "Last click was: " + time
    }
  }

  fun createContent() :ArrayList<String> {
    var result :ArrayList<String> = ArrayList<String>()

    var sortedKeys :List<Long> = ArrayList<Long>(X.content.keys)
    Collections.sort(sortedKeys)

    sortedKeys.forEach {
      val str :String? = X.content.get(it)
      if(str != null)
      {
        result.add(str)
      }
    }

    return result
  }

  fun getContent() :ArrayList<String> {
    insertTime()
    return createContent()
  }

}
