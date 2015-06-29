import org.junit.Test
import org.junit.Assert._
import junit.framework.TestCase
import java.io.{File, InputStream, ByteArrayOutputStream, FileInputStream}
import java.util.Scanner

class SolutionTest extends TestCase {

  def testLabel = "testno"
  var tests: List[(File, File)] = _

  override def setUp: Unit = {
    val testDir = "." + File.separator + "tests"
    val testDirFile = new File(testDir)

    if (sys.props.isDefinedAt(testLabel)) {
      val no = sys.props(testLabel)
      tests = List((new File(testDir + s"input$no.txt"), new File(testDir + s"output$no.txt")))
    } else {
      tests =
        for (file <- testDirFile.listFiles().toList if file.getName().startsWith("input"))
          yield (file, new File(file.getParent + File.separator + file.getName().replaceAll("input", "output")))
    }
  }

  def test(): Unit = {
    println("Running tests...")

    for ((in, out) <- tests) {
      print(s"Running test in file $in... ")

      // actual output
      val output = new ByteArrayOutputStream()
      Console.withIn(new FileInputStream(in)) {
        Console.withOut(output) {
          Solution.main(Array[String]())
        }
      }

      // expected output
      val expected = new Scanner(out).useDelimiter("\\n").next()

      // are they identical?
      if (output.toString.trim != expected.trim) {
        println("mismatch :(")
        println("output:")
        println(output)
        println("expected:")
        println(expected)
      } else
        println("ok")
    }

  }
}