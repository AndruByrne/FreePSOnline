f = File.open(ARGV.first).read
out = f.
  gsub(/\d{3}-\d{3}-\d{4}/) { |phn| # 10 digit numbers (NNN-NNN-NNNN)
    "<a href=\"tel:+1-#{phn}\">#{phn}</a>" }.
  gsub(/\s\d{3}-\d{4}/) { |phn| # 7 digit numbers (NNN-NNNN)
    " <a href=\"tel:+1-415-#{phn[1..-1]}\">#{phn[1..-1]}</a>" }

File.write(ARGV.firs, out)
