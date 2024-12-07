WITH RECURSIVE cte ( g
                   , id
                   , parent_id
                   ) AS ( -- 1세대
                           SELECT 1 AS g
                                , id
                                , parent_id
                             FROM ecoli_data
                            WHERE parent_id IS NULL
                        UNION ALL
                          -- 자식세대
                           SELECT cte.g + 1
                                , ed.id
                                , ed.parent_id
                            FROM ecoli_data ed
                      INNER JOIN cte
                              ON cte.id = ed.parent_id
                        )
                        SELECT id AS ID
                          FROM cte
                         WHERE cte.g = 3
                      ORDER BY id;