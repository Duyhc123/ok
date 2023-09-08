class GFG
{
// chức năng này tạo khóa trong
// một cách tuần hoàn cho đến khi độ dài của nó không còn nữa
// Bằng độ dài gốc của văn bản
static String generateKey(String str, String key)
{
    int x = str.length();
 
    for (int i = 0; ; i++)
    {
        if (x == i)
            i = 0;
        if (key.length() == str.length())
            break;
        key+=(key.charAt(i));
    }
    return key;
}
 
// Hàm này trả về văn bản được mã hóa
// được tạo với sự giúp đỡ của khóa
static String cipherText(String str, String key)
{
    String cipher_text="";
 
    for (int i = 0; i < str.length(); i++)
    {
        // chuyển đổi trong phạm vi  0-25
        int x = (str.charAt(i) + key.charAt(i)) %26;
 
        // chuyển đổi thành bảng chữ cái (ASCII)
        x += 'A';
 
        cipher_text+=(char)(x);
    }
    return cipher_text;
}
 
// Hàm này giải mã văn bản được mã hóa
// và trả về văn bản gốc
static String originalText(String cipher_text, String key)
{
    String orig_text="";
 
    for (int i = 0 ; i < cipher_text.length() &&
                            i < key.length(); i++)
    {
        // chuyển đổi trong phạm vi 0-25
        int x = (cipher_text.charAt(i) -
                    key.charAt(i) + 26) %26;
 
        // chuyển đổi thành bảng chữ cái (ASCII)
        x += 'A';
        orig_text+=(char)(x);
    }
    return orig_text;
}
 
// Hàm này sẽ chuyển ký tự chữ thường thành chữ in hoa
static String LowerToUpper(String s)
{
    StringBuffer str =new StringBuffer(s);
    for(int i = 0; i < s.length(); i++)
    {
        if(Character.isLowerCase(s.charAt(i)))
        {
            str.setCharAt(i, Character.toUpperCase(s.charAt(i)));
        }
    }
    s = str.toString();
    return s;
}
 
// Mã trình chiếu điều khiển
public static void main(String[] args)
{
    String Str = "HOVATEN";
    String Keyword = "KEYWORD";
       
      String str = LowerToUpper(Str);
      String keyword = LowerToUpper(Keyword);
 
    String key = generateKey(str, keyword);
    String cipher_text = cipherText(str, key);
 
    System.out.println("Ciphertext : "
        + cipher_text + "\n");
 
    System.out.println("Original/Decrypted Text : "
        + originalText(cipher_text, key));
    }
}