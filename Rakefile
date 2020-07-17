task :default => :new

require 'fileutils'
require 'tempfile'

task :git do
  puts "请输入git内容 m"
    @msg = STDIN.gets.chomp

    @slug = "#{@msg}"
    @slug = @slug.downcase.strip.gsub(' ', '-')
    @date = Time.now.strftime("%F")
    @finalmsg = "#{@date}-#{@slug}"
    system "git add ."
    system "git commit -m \"#{@finalmsg}\""
    system "git push"
    puts "git push \"#{@finalmsg}\" successfully"
end


desc "创建新LeetCode练习"
task :new do

    puts "请输入练习中文名："
    @chineseName = STDIN.gets.chomp
    puts "Please input the exercise English name："
    @name = STDIN.gets.chomp
    @date = Time.now.strftime("%F")

    # 需要检查一下对应练习的目录是否存在
    @directory_url = "./src/main/java/#{@chineseName}"
    if File.directory?(@directory_url)
        puts "The directory: #{@directory_url} has existed."
    else
        FileUtils.mkdir(@directory_url)
        puts "The directory: #{@directory_url} has created."
    end

    # 更新README.md文件
    t_file = Tempfile.new('README_TEMP.md')
    File.open("README.md", 'r') do |f|
        f.each_line{|line| t_file.puts line}
    end
    t_file.puts "- [#{@name}](#{@directory_url})"
    t_file.close
    FileUtils.mv(t_file.path, "README.md")

    # 创建对应的文件
    # 对应分类的文件放进对应的文件夹当中
    @readme_name = "#{@directory_url}/README.md"
    @java_name = "#{@directory_url}/#{@name}.java"


    if File.exist?(@readme_name)
        puts "README文件已经存在！创建失败"
    else
        # 创建readme文件
        FileUtils.touch(@readme_name)
        open(@readme_name, 'a') do |file|
            file.puts "# #{@date} #{@name}"
            file.puts "[地址]()"
            file.puts ""
            file.puts "## 原理"
            file.puts ""
            file.puts ""
            file.puts "## 结论"
        end
    end


    # 创建Java文件
    if File.exist?(@java_name)
        puts "java文件已经存在！创建失败"
    else
        # 创建java文件
        FileUtils.touch(@java_name)
        open(@java_name, 'a') do |file|
            file.puts "package #{@name};"
            file.puts ""
            file.puts "/**"
            file.puts "* Created by ymkNK on #{@date}."
            file.puts "*/"
            file.puts "public class #{@name} {"
            file.puts ""
            file.puts "    public static void main(String[] args) {"
            file.puts ""
            file.puts ""
            file.puts ""
            file.puts "    }"
            file.puts "}"
        end
    end


    puts "rake new successfully"
end