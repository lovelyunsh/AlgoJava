import numpy as np


a = [1,2,3]
b = [2,3,4]
a = np.array(a)

pose_i = np.array([2, 3, 30])
pose_j = np.array([3, 5, 60])

R_i = np.array([[np.cos(np.deg2rad(pose_i[2])), np.sin(np.deg2rad(pose_i[2]))],
       [-np.sin(np.deg2rad(pose_i[2])), np.cos(np.deg2rad(pose_i[2]))]])
t_i = -np.matmul(R_i,pose_i[:2])

print(t_i)

R_ij = [[np.cos(np.deg2rad(pose_i[2] - pose_j[2])), np.sin(np.deg2rad(pose_i[2] - pose_j[2]))],
        [-np.sin(np.deg2rad(pose_i[2] - pose_j[2])), np.cos(np.deg2rad(pose_i[2] - pose_j[2]))]
        ]

print(R_ij)
t_ij = np.matmul(R_ij,pose_i[:2] - pose_j[:2])
print(t_ij)

print(np.arctan2(1.8660254,1.23205081))