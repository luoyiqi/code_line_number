package com.skk;

import java.io.File;

import javax.swing.JOptionPane;
/**
 * 功能：统计Java工程下所有代码的数量（Java，jsp，xml）

 */
public class Test {
	public static void main(String[] args) {
		String path = JOptionPane.showInputDialog("请输入工程路径");
		File directory = new File(path);
		if (!directory.exists()) {
			JOptionPane.showMessageDialog(null, "路径不存在", null,
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		Numbers numbers = new Numbers(directory);
		JOptionPane.showMessageDialog(null, "Java代码:" + numbers.getJavaLines()
				+ "行\njsp代码：" + numbers.getJspLines() + "行\nxml代码："
				+ numbers.getXmlLines() + "行");
	}
}
