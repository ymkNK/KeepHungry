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
    puts "Please input the exercise name："
    @name = STDIN.gets.chomp
    @date = Time.now.strftime("%F")

    # 需要检查一下对应练习的目录是否存在
    @directory_url = "./src/main/java/#{@name}"
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

end