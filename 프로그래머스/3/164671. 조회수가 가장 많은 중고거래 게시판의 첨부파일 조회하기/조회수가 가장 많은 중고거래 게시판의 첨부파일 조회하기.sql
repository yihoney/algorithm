  SELECT CONCAT('/home/grep/src/', ugf.board_id, '/', ugf.file_id, ugf.file_name, ugf.file_ext) AS FILE_PATH
    FROM used_goods_file ugf
   WHERE ugf.board_id = (
                             SELECT board_id
                               FROM used_goods_board
                           ORDER BY views DESC
                              LIMIT 1
                        )
ORDER BY ugf.file_id DESC;