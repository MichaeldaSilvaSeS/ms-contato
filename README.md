# ms-contato
Spring boot cloud


https://www.devmedia.com.br/utilizando-criptografia-simetrica-em-java/31170
https://www.mkyong.com/java/how-to-read-utf-8-xml-file-in-java-sax-parser/



		String salt = KeyGenerators.string().generateKey();
		System.out.println(salt);
		TextEncryptor textEncryptor = Encryptors.queryableText("abc", "c3e31a63785f3061");
		String originalText = "abcd";
		String old = "3cef79ac548f7b38612f3a36ba72ca64";
		System.out.println(originalText);
		String textEncrypted = textEncryptor.encrypt(originalText);
		System.out.println("OLD:"+old);
		System.out.println("NEW:"+textEncrypted);
		System.out.println(old.equals(textEncrypted));
		String textDecrypted = textEncryptor.decrypt(textEncrypted);
		System.out.println(textDecrypted);
