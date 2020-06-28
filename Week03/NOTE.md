**

1.递归的解题方法
	1.1.递归中止条件

	1.2.处理当前层逻辑

	1.3.下探到下一层

	1.4.清理当前层
	
	
代码模板：
public void recur(int level, int param) { 
  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic 
  process(level, param); 
  // drill down 
  recur( level: level + 1, newParam); 
  // restore current status 
 
}

总结：
1. 不要人肉进行递归（最大误区）
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
3. 数学归纳法思维

==================================================================================================

回溯：

回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种 情况：

• 找到一个可能存在的正确的答案；

• 在尝试了所有可能的分步方法后宣告该问题没有答案。


