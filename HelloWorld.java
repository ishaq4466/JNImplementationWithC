class HelloWorld
{
	private native void printHello();
	public static void main(String[] args) {
		
		HelloWorld h1=new HelloWorld();
		h1.printHello();
	}

	static
	{
		System.loadLibrary("HelloWorld");
	}

}