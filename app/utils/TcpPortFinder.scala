package utils

import java.net.ServerSocket

object TcpPortFinder {
  def findAvailablePort : Int = {
    var port = 0
    var s: ServerSocket = null
    try {
      s = new ServerSocket(0)
      port = s.getLocalPort
    } finally {
      s.close()
    }
    port
  }

  def findAvailablePort(minPort: Int, maxPort:Int) : Int = {
    var port = minPort
    var retry = true
    while (retry && port <= maxPort ) {
      var s: ServerSocket = null
      try {
        s = new ServerSocket(port)
        port = s.getLocalPort
        retry = false
      }catch{
        case e:Exception=>{
          port+=1
        }
      } finally {
        s.close()
      }
    }
    port
  }
}