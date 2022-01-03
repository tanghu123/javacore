package com.jimi.learning.security;

import java.text.Normalizer;
import java.text.Normalizer.Form;

public class NormalizerT {

	public static void main(String[] args) {
		String str = "\uFE64"+"script"+"\uFE65";
		System.out.println("Before process " + str);
		Normalizer.isNormalized(str, Form.NFKC);
	}

}
