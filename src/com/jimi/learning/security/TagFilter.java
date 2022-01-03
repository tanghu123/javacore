package com.jimi.learning.security;

import java.text.Normalizer;
import java.text.Normalizer.Form;

public class TagFilter {

	public static void main(String[] args) {
		String tag = "<scr" + "\u0021" + "ipt>";
		System.out.println(tag);
		String str = Normalizer.normalize(tag, Form.NFKC);
		System.out.println(str);
	}

}
