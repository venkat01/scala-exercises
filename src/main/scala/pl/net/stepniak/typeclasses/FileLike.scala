package pl.net.stepniak.typeclasses

import java.io._

trait FileLike[T] {
  def name(file: T): String
  def exists(file: T): Boolean
  def isDirectory(file: T): Boolean
  def children(directory: T): Seq[T]
  def child(parent: T, name: String): T
  def mkdirs(file: T): Unit
  def content(file: T): InputStream
  def writeContent(file: T, otherContent: InputStream): Unit
}

object FileLike {
  implicit val ioFileLike = new FileLike[File] {
    override def writeContent(file: File, otherContent: InputStream): Unit = {
      val output = new BufferedOutputStream(new FileOutputStream(file))
      try {
        val input = new BufferedInputStream(otherContent)
        val buffer = new Array[Byte](512)
        var ready = 0
        ready = input.read(buffer)
        while (ready != -1) {
          if (ready > 0) {
            output.write(buffer, 0, ready)
          }
          ready = input.read(buffer)
        }
      } finally {
        otherContent.close()
        output.close()
      }
    }

    override def content(file: File): InputStream = new FileInputStream(file)

    override def mkdirs(file: File): Unit = file.mkdirs()

    override def child(parent: File, name: String): File = new File(parent,name)

    override def children(directory: File): Seq[File] = directory.listFiles()

    override def isDirectory(file: File): Boolean = file.isDirectory

    override def exists(file: File): Boolean = file.exists()

    override def name(file: File): String = file.getName
  }
}