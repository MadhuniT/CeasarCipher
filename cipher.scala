object CeasarCipher extends App{
  val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

  val encrypting = (c: Char, key: Int, alphabet: String) => alphabet((alphabet.indexOf(c.toUpper) + key) % alphabet.size)
  val decrypting = (c: Char, key: Int, alphabet: String) => alphabet((alphabet.indexOf(c.toUpper) - key + alphabet.size) % alphabet.size)

  val cipher = (algo: (Char, Int, String) => Char, s: String, key: Int, alphabet: String) => s.map(algo(_,key,alphabet))

  val shift = (scala.io.StdIn.readLine("Shift By: ").toInt + alphabet.size) % alphabet.size
  val message = scala.io.StdIn.readLine("Secret Message to encrypt: ")

  val encryptText = cipher( encrypting, message, shift, alphabet)
  val decryptText = cipher(decrypting, encryptText, shift, alphabet)

  print("Encrypted message is : ")
  println(encryptText)
  print("Decrypted message: ")
  println(decryptText)

}