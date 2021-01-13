# 2021-01-10 从上到下打印二叉树 PrintBinaryTreeFromRootToEnd
[地址](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof)


从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

 

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回：

[3,9,20,15,7]


## 原理

bfs，广度优先搜索，一般使用队列queue（LinkedList）来使用

## 结论
